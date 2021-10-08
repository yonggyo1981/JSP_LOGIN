package com.controller.member;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

import com.models.dao.MemberDao;

/**
 * 회원 가입 
 * GET - 가입 양식, POST - 가입 처리 
 */
public class JoinController extends HttpServlet {
	
	/** 회원가입 양식 */
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("/member/form.jsp");
		rd.include(request, response);
	}
	
	/** 회원가입 처리 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MemberDao dao = new MemberDao();
		dao.join(request);
	}
}





