package com.touch.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.touch.dao.HibernateManager;

/**
 * Servlet implementation class ProfileCreation
 */
@WebServlet("/ProfileCreation")
public class ProfileCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String touchID = request.getParameter("touchID");
		
		String bio = request.getParameter("bio");
		
		String status = request.getParameter("status");
		
		String dob = request.getParameter("dob");
		
		String profilePic = request.getParameter("profilePic");
		
		FileInputStream image = null;
		
		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
		
		
		if(isMultiPart)
		{
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			File tmpFile = new File("C:\\Users\\anilk\\eclipse-workspace\\FirstProjectInServlets\\WebContent\\tmp\\");
			
			factory.setRepository(tmpFile);
			
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			
			try {
					List<FileItem> items = fileUpload.parseRequest(request);
					
					for(FileItem item : items )
					{
						if(item.isFormField())
						{
							String fieldName = item.getFieldName();
							if(fieldName.equals("touchID"))
							{
								touchID = item.getString();
							}
							
							else if(fieldName.equals("bio"))
							{
								bio = item.getString();
							}
							else if(fieldName.equals("dob"))
							{
								dob = item.getString();
							}
							else if(fieldName.equals("status"))
							{
								status = item.getString();
							}
							
						else
						{
							image = (FileInputStream) item.getInputStream();
						}
					}
					
			    }
			}
			catch (FileUploadException e) 
			{
				e.printStackTrace();
			}
			
			System.out.println("Image Path : " + image);
			
			HttpSession session = request.getSession();
		
			String email = session.getAttribute("email").toString();
			
			HibernateManager hm = new HibernateManager();
			
			if(hm.validateRegisterer(email))
		
	}

}
	
}
