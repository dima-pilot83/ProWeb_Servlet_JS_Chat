package ru.mail.dimapilot;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LogINOFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<String> i = new ArrayList<String>();

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
		String user = request.getParameter("USER");

		String pathname = "D://Chat//STATUS.js";

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String temp = base.get(login);
		if (password.equals(temp)) {
			response.sendRedirect("" + login + "0.html");

			adduser(pathname, login);

		}

		if (password.equals(temp) == false) {
			response.sendRedirect("loginbad.html");
		}
		// if
		// (user.equals("USER1")||user.equals("USER2")||user.equals("USER2")||user.equals("USER2"))
		// {
		// deleteuser(pathname, user);
		// }

	}

	protected synchronized void adduser(String pathname, String user) {
		try {
			i.add(user);

			Writer writer = new FileWriter(pathname);
			writer.write("var status = '" + i.toString() + "';");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected synchronized void deleteuser(String pathname, String user) {
		try {
			i.remove(user);
			Writer writer = new FileWriter(pathname);
			writer.write("");
			writer.write("var status = '" + i.toString() + "';");
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
