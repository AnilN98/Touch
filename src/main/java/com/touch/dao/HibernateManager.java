package com.touch.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.touch.model.TouchRegisterer;

public class HibernateManager 
{
	Session session;
	
	public HibernateManager()
	{
		System.out.println("Inside HibernateManager Constructor");
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(TouchRegisterer.class)
				.buildSessionFactory();
		session = factory.getCurrentSession();
		System.out.println("Connection to touch DB is established...!!");
	}
	
	public boolean registerRegisterer(TouchRegisterer tr)
	{ 
		System.out.println("Inside registerRegisterer()");
		Transaction t = session.beginTransaction();
		session.save(tr);
		System.out.println("Registerer Details Registered in DB");
		t.commit();
		System.out.println("Registerer Details Commited in DB");
		return true;
	}
	
	public List<TouchRegisterer> fetchRegisterer(TouchRegisterer tr)
	{
		System.out.println("Inside fetchRegisterer");
		
		System.out.println(tr);
		
		Transaction t = session.beginTransaction();
		
		System.out.println("Transaction began");
		
		List<TouchRegisterer> t_Registerer_Details = session.createQuery("from TouchRegisterer tr where tr.email = '" + tr.getEmail()+ "'").list();
		
		System.out.println("Registerer Details :");
		
		for(TouchRegisterer detail : t_Registerer_Details)
		{
			System.out.println(detail);
		}
		
		t.commit();
		
		return t_Registerer_Details;
	}
	
	public boolean validateRegisterer(String email)
	{
		Transaction t = session.beginTransaction();
		
		System.out.println("Transaction began");
		
		List<TouchRegisterer> t_Registerer_Details = session.createQuery("from TouchRegisterer tr where tr.email = '" +email + "'").list();
		
		System.out.println("Registerer Details :");
		
		if(!t_Registerer_Details.isEmpty() && t_Registerer_Details !=null)
		{
			t.commit();
			return true;
		}
		else
		{
			t.commit();
			System.out.println("Object List is Empty in validateRegisterer");
			return false;
		}
		
		
		
		
		
	}
	
	
}
