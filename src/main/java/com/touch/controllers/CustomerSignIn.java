package com.touch.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();
		
		List <TouchRegisterer> tr_Details= hm.fetchRegisterer(tr);
		
		System.out.println("Printing from CustomerSignIn Servlet");
		
		for(TouchRegisterer tr1 : tr_Details)
		{
			System.out.println("Email : " + tr1.getEmail());
			System.out.println("Password : " + tr1.getPassword());
			
			toCheckemail = tr1.getEmail();
			
			toCheckpwd = tr1.getPassword();
		}
		
		System.out.println("Entered Email : " + email);
		System.out.println("Entered Password : "+ password);
		
		if(hm.validateRegisterer(email)==true)
		{
			System.out.println("\n\n\n***mail found in Touchregister Table");
			if(email.equals(toCheckemail)==true && password.equals(toCheckpwd)==true)
			{
				System.out.println("\n\n\n***inside if condition of validateprofileRegisterer(), email & password Validated");
				
				if(hm.validateprofileRegisterer(email))
				{
					System.out.println("\n\n\n***mail found in Profile Register Table");
					session.setAttribute("email", email);
					hm.getAllProfiles();
					response.sendRedirect("/Touch/profileFeedPg.jsp");
				}
				else
				{
					System.out.println("Customer have not created profile");
					session.setAttribute("email", email);
					
					response.sendRedirect("/Touch/profileCreation.jsp");
					
				}
			}
			else
			{
				System.out.println("inside else condition of validateprofileRegisterer(), " + email + " has not registered for Profile Creation");
				response.sendRedirect("/Touch/wrongDetails.html");
			}
	
		}
		else
		{
			System.out.println("inside else condition of validateprofileRegisterer(), " + email + " has NOT FOUND in TOUCH DB");
			response.sendRedirect("/Touch/wrongDetails.html");
		}
		

}
}