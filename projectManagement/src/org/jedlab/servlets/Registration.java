package org.jedlab.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registeration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<String> usernames = Collections.synchronizedList(Arrays.asList("jedlab", "user1", "user2"));
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("username");
		System.out.println(uname);
		PrintWriter out = response.getWriter();
		if(usernames.contains(uname))
		{
			out.write("found");
		}
		else
		{
			out.write("not found");
		}
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		System.out.println(uname);		
		request.setAttribute("uname", uname);
		request.getSession(true).setAttribute("isLogin", true);
		request.getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
		
	}

}
