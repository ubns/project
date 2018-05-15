package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.PracticeDao;

@WebServlet("/Practice")
public class PracticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッションを解放し、トップ画面へ遷移する
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 問題を登録する
		request.setCharacterEncoding("UTF-8");
		String question = request.getParameter("question");
		String answer1 = request.getParameter("answer1");
		String answer2 = request.getParameter("answer2");
		String answer3 = request.getParameter("answer3");
		String answer = request.getParameter("answer");
		int answerNo = Integer.parseInt(answer); 
		PracticeDao dao = new PracticeDao();
		dao.create(question, answer1, answer2, answer3, answerNo);
		request.setAttribute("message", "登録が完了しました。");
		RequestDispatcher rd = request.getRequestDispatcher("/auth/dashboard.jsp");
		rd.forward(request, response);
	}

}
