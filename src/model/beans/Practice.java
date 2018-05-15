package model.beans;

import java.io.Serializable;

public class Practice implements Serializable {
	private int practice_code;
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private int answer_code;
	
	public Practice() {
		
	}
	
	public Practice(int practice_code, String question, String answer1, String answer2, String answer3, int answer_code) {
		this.practice_code = practice_code;
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer_code = answer_code;
	}
	
	public int getPractice_code() {
		return practice_code;
	}
	public void setPractice_code(int practice_code) {
		this.practice_code = practice_code;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public int getAnswer_code() {
		return answer_code;
	}
	public void setAnswer_code(int answer_code) {
		this.answer_code = answer_code;
	}
	
	
}
