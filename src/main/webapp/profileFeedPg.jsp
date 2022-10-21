<%@page import="com.touch.model.ProfileRegisterer"%>
<%@page import="com.touch.dao.HibernateManager"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Feed</title>
</head>
<body>
<%
	if(session.getAttribute("email")==null)
	{
		
	
		response.sendRedirect("homePg.jsp");
		
		out.println("Inisde if condition in UserApply.jsp !!! user has been redirected because he hasnot provided login id ");
	}
	else
	{
		HibernateManager hm = new HibernateManager();
		
		//List profiles =  hm.getAllProfiles();
		
		//System.out.println("\n\n\nInside Profile Feed Page : " + profiles);
		
	}
%>
<table>
	<tr><th>Customer Name </th><th>&nbsp;&nbsp;&nbsp;User ID :</th><th>&nbsp;&nbsp;&nbsp;Email ID :</th><th></tr>
	
	
		
	<% %>
	
	</table>
	

</body>
</html>