package com.touch.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.touch.dao.HibernateManager;
import com.touch.model.TouchRegisterer;



@WebServlet("/customerSignUp")
public class CustomerSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String name = request.getParameter("name");
		
		String password = request.getParameter("password");
		
		String conPassword = request.getParameter("cpassword");
		
		String email = request.getParameter("email");
		
		String mobileNum = request.getParameter("mobile");
		
		HttpSession session = request.getSession();
		
		if(password.equals(conPassword)==false)
		{
			response.sendRedirect("/Touch/passwordMismatch.html");
		}
		else
		{
			TouchRegisterer tr = new TouchRegisterer(name, password, email, mobileNum);
			
			HibernateManager hm = new HibernateManager();
			
			boolean status = hm.registerRegisterer(tr);
			
			if(status==true)
			{
				response.sendRedirect("/Touch/profileCreation.jsp");
				session.setAttribute("email", email);
			}
			else
			{
				response.sendRedirect("/Touch/regFailure.html");
			}
		}
	}

}
