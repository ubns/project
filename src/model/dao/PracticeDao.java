package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class PracticeDao {
	Connection conn;
	PreparedStatement st;
	
	public PracticeDao() {
		DBConnection dbcon = new DBConnection();
		conn = dbcon.getConnection();
	}
	
	public void create(String question, String answer1, String answer2, String answer3, int answerNo) {
		if (conn == null) {
			DBConnection dbcon = new DBConnection();
			conn = dbcon.getConnection();
		}
		
		try {
			Date date = new Date(Calendar.getInstance().getTimeInMillis());
			
			String practice = "INSERT INTO practice (question, answer_code,create_date,update_date) VALUES (?,?,?,?) ";
			st = conn.prepareStatement(practice);
			st.setString(1, question);
			st.setInt(2, answerNo);
			st.setDate(3, date);
			st.setString(4, null);
			st.executeUpdate();
			
			String answer = "INSERT INTO answer (answer_code,answer1,answer2,answer3,create_date,update_date) VALUES (?,?,?,?,?,?) ";
			st = conn.prepareStatement(answer);
			st.setInt(1, answerNo);
			st.setString(2, answer1);
			st.setString(3, answer2);
			st.setString(4, answer3);
			st.setDate(5, date);
			st.setString(6, null);
			st.executeUpdate();
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
	}
}
