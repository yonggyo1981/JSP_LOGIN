package com.core;

import java.sql.*;
import javax.servlet.FilterConfig;

/**
 * DB 연결 클래스 
 *
 */
public class DB {
	
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	public static void init(FilterConfig config) {
		
	}
	
	public static void init(String driver, String url, String user, String password) {
		DB.driver = driver;
		DB.url = url;
		DB.user = user;
		DB.password = password;
	}
}
