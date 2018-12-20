package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.InsertCustomerRecord;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		int regNumber = Integer.parseInt(request.getParameter("regnum"));
		String name = request.getParameter("cusname");
		String address = request.getParameter("address");
		String emailID = request.getParameter("emailid");
		int number = Integer.parseInt(request.getParameter("phonenum"));
		String password = request.getParameter("password");
		
		InsertCustomerRecord icr = new InsertCustomerRecord();
		icr.insert(regNumber, name, address, emailID, number,password);
		out.println("Successfully registered");
	
	}

}
