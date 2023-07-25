package com.kh.jdbc.day04.student.common;

import java.sql.*;

public class JDBCTemplate {
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private final String USER = "STUDENT";
	private final String PASSWORD = "STUDENT"; 
	
	private static JDBCTemplate instance;
	
	private JDBCTemplate() {}

	public static JDBCTemplate getInstance() {
		// 이미 만들어져 있는지 체크하고
		if(instance == null) {
			// 안만들어져 있으면 만들어 사용
			instance = new JDBCTemplate();
		}
		// 만들어져 있으면 그거 사용해
		return instance;
	}
	
	public Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// DBCP(DataBase Connection Pool)
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
