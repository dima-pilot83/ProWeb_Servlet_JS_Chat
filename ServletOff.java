package ru.mail.dimapilot;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logout")
public class ServletOff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Write wr = new Write();

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
