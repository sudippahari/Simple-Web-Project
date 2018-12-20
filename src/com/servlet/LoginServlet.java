package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.CheckRecord;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	
		
		int regNum = Integer.parseInt(request.getParameter("regnum"));
		String password = request.getParameter("password");
		String option = request.getParameter("login");
		
		if(option.equals("submit")){
			CheckRecord cr = new CheckRecord();
			
			int checkResult = cr.checkRecord(regNum,password);
			if(checkResult == 0){
				out.println("Login Failed");
			}else{
				out.println("Login successful");
			}
			
		}else{
			response.sendRedirect("./registration.html");
			
		}
		
		
		
		
		
	}

}
