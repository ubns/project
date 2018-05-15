package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.User;

public class AuthDao {
	private final String SQL = "SELECT * FROM USER WHERE name = ? AND pass = ?";
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	
	public AuthDao() {
		DBConnection dbcon = new DBConnection();
		conn = dbcon.getConnection();
	}
	
	public boolean isLogin(String name, String pass) {
		if (conn == null) {
			DBConnection dbcon = new DBConnection();
			conn = dbcon.getConnection();
		}
		
		List<User> list = null;
		try {
			st = conn.prepareStatement(SQL);
			st.setString(1, name);
			st.setString(2, pass);
			rs = st.executeQuery();
			list = new ArrayList<User>();
			while(rs.next()) {
				User bean = new User(rs.getString("name"),rs.getString("pass"), rs.getDate("create_date"), rs.getDate("update_date"));
				list.add(bean);
			}
		} catch (SQLException e) {
			System.out.println("SQLエラーが発生しました。" + e);
		} finally {
			try {
				if (st != null) st.close();
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				System.out.println("リソース解放に失敗しました。");
			}
		}
		
		if (list.size() == 1) {
			return true; // ログインOK
		} else {
			return false;  // ログインNG
		}
	}
	
}
