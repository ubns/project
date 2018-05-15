package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.AuthDao;


@WebServlet("/Auth")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Getリクエストの場合はログインページへ返す
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Postの場合のみ認証処理を行う
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		AuthDao dao = new AuthDao();
		if (dao.isLogin(name, pass)) {
			// ログイン成功
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			RequestDispatcher rd = request.getRequestDispatcher("/auth/dashboard.jsp");
			rd.forward(request, response);
		} else {
			// ログイン失敗
			request.setAttribute("message", "ユーザ名またはパスワードが違います。");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}

}
