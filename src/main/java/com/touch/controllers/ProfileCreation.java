package com.touch.controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.touch.dao.HibernateManager;
import com.touch.model.ProfileRegisterer;

/**
 * Servlet implementation class ProfileCreation
 */
@WebServlet("/ProfileCreation")
@MultipartConfig(maxFileSize =16177215)
public class ProfileCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String touchID = request.getParameter("touchID");
		
		String bio = request.getParameter("bio");
		
		String status = request.getParameter("status");
		
		String dob = request.getParameter("dob");
		
		String profilePic = request.getParameter("profilePic");
		
		String interests = request.getParameter("interests");
		
		Part part = request.getPart("profilePic");
		
		InputStream is = null;
		if(part != null)
			is = part.getInputStream();
		
		byte[] image = new byte[is.available()];
		
		is.read(image);
		
				System.out.println("Image Path : " + image);
			
				HttpSession session = request.getSession();
		
				String email = session.getAttribute("email").toString();
			
				HibernateManager hm = new HibernateManager();
			
				if(hm.validateRegisterer(email))
				{
					System.out.println("\n\n\n "+ email  +" is available in Touch Register Table");
					ProfileRegisterer pr = new ProfileRegisterer(touchID, bio, dob, status, image, interests, email);
				
					boolean queryStatus = hm.profileRegisterer(pr);
				
					if(queryStatus==true)
					{
						System.out.println("\n\n\n *** Profile is CREATED");
						response.sendRedirect("/Touch/regSuccessful.html");
						session.setAttribute("email", email);
					
					}
					else
					{
						System.out.println("\n\n\n *** Profile is NOT CREATED");
						response.sendRedirect("/Touch/regFailure.html");
					}
				}
				else
				{
					System.out.println("\n\n\n *** Email is NOT Avaiable in Touch Register Table");
					response.sendRedirect("/Touch/wrongDetails.html");
				}
				
		
			}

		}
	

