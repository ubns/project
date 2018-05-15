package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private final String URL = "jdbc:mysql://localhost/training?serverTimezone=UTC&useSSL=false";
	private final String USER = "student";
	private final String PASS = "himitu";
	private Connection conn;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCの読み込みに失敗しました。" + e);
		} catch (SQLException e) {
			System.out.println("データベース系エラーが発生しました。" + e);
		}
		return conn;
	}
}
