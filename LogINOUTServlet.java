package ru.mail.dimapilot;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LogINOUTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Write wr = new Write();

	static final Map<String, String> base = new HashMap<String, String>();

	static {
		base.put("USER1", "111");
		base.put("USER2", "222");
		base.put("USER3", "333");
		base.put("USER4", "444");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		String pathname = "D://Chat//STATUS.js";

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String temp = base.get(login);
		if (password.equals(temp)) {
			response.sendRedirect("" + login + "0.html");

			wr.adduser(pathname, login);

		}

		if (password.equals(temp) == false) {
			response.sendRedirect("loginbad.html");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("USER");
		String pathname = "D://Chat//STATUS.js";

		if (user != null) {
			wr.deleteuser(pathname, user);
			response.sendRedirect("login.html");
		}

	}
}
