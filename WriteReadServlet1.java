package ru.mail.dimapilot;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WriteRead1")
public class WriteReadServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WriteReadServlet1() {
		super();
	}

	private Write wr = new Write();
	protected String answer;

	long t = System.currentTimeMillis();
	Date dd = new Date(t);
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm");
	String resdata = dateFormat.format(dd);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mess = request.getParameter("mess");
		String to = request.getParameter("SendTo");
		String from = request.getParameter("USER");
		String check = request.getParameter("Check");
		
		String pathname1 = "D://Chat//"+from+".js";
		String pathname2 = "D://Chat//"+to+".js";
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		try {
			wr.write(pathname1,resdata, from, to, mess);
			wr.write(pathname2,resdata, from, to, mess);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		try {
			
			if (check.equals("0")) {
				response.sendRedirect("" + from + "0.html");
			}
			if (check.equals("1")) {
				response.sendRedirect("" + from + "1.html");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
