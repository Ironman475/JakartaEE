package academy.prog;

import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
	static final int QUESTION_1_YES = 0;
	static final int QUESTION_1_NO = 1;
	static final int QUESTION_2_YES = 2;
	static final int QUESTION_2_NO = 3;
	final int[] answer = new int[4];

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		final String msg1 = req.getParameter("firstName");
		final String msg2 = req.getParameter("lastName");
		final String msg3 = req.getParameter("age");

		final String q1 = req.getParameter("question1");
		final String q2 = req.getParameter("question2");

		final int idx1 = "yes".equals(q1) ? QUESTION_1_YES : QUESTION_1_NO;
		final int idx2 = "yes".equals(q2) ? QUESTION_2_YES : QUESTION_2_NO;

		answer[idx1]++;
		answer[idx2]++;

		PrintWriter pw = resp.getWriter();
		pw.println("<html><head><title>Bzh.Vladimir</title></head>");
		pw.println("<body><h1>Your name is " + msg1 + "</h1>");
		pw.println("<h2>Your last name is " + msg2 + "</h2>");
		pw.println("<h3>Your age is " + msg3 + "</h3>");
		pw.println("<p>Question 1 : yes = " + answer[QUESTION_1_YES] + ", no = " + answer[QUESTION_1_NO] + "<p>");
		pw.println("<p>Question 2 : yes = " + answer[QUESTION_2_YES] + ", no = " + answer[QUESTION_2_NO] + "<p>");
	}
}
