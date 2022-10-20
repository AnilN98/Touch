package com.touch.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.touch.dao.HibernateManager;
import com.touch.model.TouchRegisterer;

/**
 * Servlet implementation class CustomerSignIn
 */
@WebServlet("/CustomerSignIn")
public class CustomerSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		
		String password = request.getParameter("password");
		
		String toCheckemail = "";
		
		String toCheckpwd = "";
		
		TouchRegisterer tr = new TouchRegisterer(email, password);
		
		HibernateManager hm = new HibernateManager();
		
		List <TouchRegisterer> tr_Details= hm.fetchRegisterer(tr);
		
		System.out.println("Printing from CustomerSignIn Servlet");
		
		for(TouchRegisterer tr1 : tr_Details)
		{
			System.out.println("Email : " + tr1.getEmail());
			System.out.println("Password : " + tr1.getPassword());
			
			toCheckemail = tr1.getEmail();
			
			toCheckpwd = tr1.getPassword();
		}
		
		if(email.equals(toCheckemail)==true && password.equals(toCheckpwd)==true)
		{
			response.sendRedirect("/Touch/profileCreation.html");
		}
		else
		{
			response.sendRedirect("/Touch/wrongDetails.html");
		}
	
	}

}
