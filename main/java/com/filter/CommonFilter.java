package com.filter;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * 사이트 공통 필터
 *
 */
public class CommonFilter implements Filter {
	
	// 정적 경로 -> 헤더, 푸터 출력 X 
	private String[] staticDirs = {"public"};
	
	
	@Override 
	public void init(FilterConfig filterConfig) {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		
		// 헤더 출력
		printHeader(request, response);
		
		chain.doFilter(request, response);// 다음 필터로 넘어가거나 없으면 서블릿넘어간다
	
		// 푸터 출력 
		printFooter(request, response);
	}
	
	/** 헤더 HTML 출력 */
	public void printHeader(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("/outline/header.jsp");
		rd.include(request, response);
	}
	
	/** 푸터 HTML 출력 */
	public void printFooter(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/outline/footer.jsp");
		rd.include(request, response);
	}
	
	/** 헤더, 푸터를 출력해도 되는지 체크하는 메서드 */
	public boolean isPrintOk(ServletRequest request) {
		/**
		 * 1. 요청 method이 GET이 아닌 경우 출력 제외(return false)
		 * 			HttpServletRequest  -  getMethod()
		 * 2.정적 경로인 경우 헤더 푸터 출력 제외(return false)
		 *  	   URI에 정적 경로가 포함되어 있으면 false
		 *  		HttpServletRequest - getRequestURI();
		 */
		
		return true;
	}
}



