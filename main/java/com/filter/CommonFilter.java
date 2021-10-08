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
		RequestDispatcher rd = request.getRequestDispatcher("/outline/header.jsp");
		rd.include(request, response);
	}
	
	/** 푸터 HTML 출력 */
	public void printFooter(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/outline/footer.jsp");
		rd.include(request, response);
	}
}



