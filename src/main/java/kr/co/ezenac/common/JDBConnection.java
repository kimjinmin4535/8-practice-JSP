package kr.co.ezenac.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBConnection {

	public Connection con;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	//기본 생성자
	public JDBConnection() {
		try {
			//JDBC 드라이버 연로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//DB연결
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String id = "ezen";
			String pw = "0824";
			
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("db 연결 성공");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
		}
	}
	
	public JDBConnection(String driver, String url, String id, String pw) {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
			
		} catch (ClassNotFoundException | SQLException e) {
			
		}
	}
	
	public void close() {
		
			try {
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
