package com.models.dao;

import javax.servlet.http.HttpServletRequest;
import java.sql.*;

import com.core.*;
import com.exception.*;

/**
 * 회원 Model
 *
 */
public class MemberDao {
	/**
	 * 회원 가입 처리 
	 * 
	 * @param request
	 * @return
	 */
	public boolean join(HttpServletRequest request) throws AlertException {
		
		String sql = "INSERT INTO member (memId, memPw, memNm) VALUES(?,?,?)";
		try (Connection conn = DB.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			String memId = request.getParameter("memId");
			String memPw = request.getParameter("memPw");
			String memNm = request.getParameter("memNm");
			
			pstmt.setString(1, memId);
			pstmt.setString(2, memPw);
			pstmt.setString(3, memNm);
			
			int result = pstmt.executeUpdate();
			if (result < 1) 
				return false;
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) { // 추가된 회원 번호
				int memNo = rs.getInt(1);
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
