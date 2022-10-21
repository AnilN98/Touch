package com.touch.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.touch.model.ProfileRegisterer;
import com.touch.model.TouchRegisterer;

public class HibernateManager 
{
	Session session ;
	Session session1;
	Session session2;
	Session session3;
	Session session4;
	Session session5;
	public HibernateManager()
	{
		System.out.println("Inside HibernateManager Constructor");
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(TouchRegisterer.class)
				.buildSessionFactory();
		
		session = factory.getCurrentSession();
		
		System.out.println("\n\n\n Current Session : " + session + "  \t session");
		
		
		SessionFactory factory1 = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(TouchRegisterer.class)
				.buildSessionFactory();
		
		session1 = factory1.getCurrentSession();
		
		System.out.println("\n\n\n Current Session : " + session1 + "  \t session1");
		
		SessionFactory factory2 = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(TouchRegisterer.class)
				.buildSessionFactory();
		
		session2 = factory2.getCurrentSession();
		
		System.out.println("\n\n\n Current Session : " + session2 + "  \t session2");
		
		SessionFactory factory3 = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProfileRegisterer.class)
				.buildSessionFactory();
		
		session3 = factory3.getCurrentSession();
		
		System.out.println("\n\n\n Current Session : " + session3 + "  \t session3");
		
		SessionFactory factory4 = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ProfileRegisterer.class)
				.buildSessionFactory();
		
		session4 = factory4.getCurrentSession();
		
		System.out.println("\n\n\n Current Session : " + session4 + "  \t session4");
		
		
		SessionFactory factory5 = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(ProfileRegisterer.class).buildSessionFactory();
		
		session5 = factory5.getCurrentSession();
		
		System.out.println("\n\n\n*** session5 created");
		
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
		
		Transaction t = session1.beginTransaction();
		
		System.out.println("Transaction began");
		
		List<TouchRegisterer> t_Registerer_Details = session1.createQuery("from TouchRegisterer tr where tr.email = '" + tr.getEmail()+ "'").list();
		
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
		Transaction t = session2.beginTransaction();
		
		System.out.println("Transaction began");
		
		List<TouchRegisterer> t_Registerer_Details = session2.createQuery("from TouchRegisterer tr where tr.email = '" +email + "'").list();
		
		System.out.println("Registerer Details : " + t_Registerer_Details);
		
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
	
	public boolean profileRegisterer(ProfileRegisterer pr)
	{ 
		System.out.println("Inside profileRegisterer() in HibernateManagerDao");
		Transaction t = session3.beginTransaction();
		session3.save(pr);
		System.out.println("Profile Registerer Details Registered in DB");
		t.commit();
		System.out.println("Profile Registerer Details Commited in DB");
		return true;
	}
	
	public boolean validateprofileRegisterer(String email)
	{ 
		System.out.println("Inside profileRegisterer() in HibernateManagerDao");
		Transaction t = session4.beginTransaction();
		
		System.out.println("Transaction began");
		
		List<TouchRegisterer> t_Registerer_Details = session4.createQuery("from ProfileRegisterer pr where pr.email = '" + email + "'").list();
		
		System.out.println("Registerer Details : " + t_Registerer_Details);
		
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
	
	
	public void getAllProfiles()
	{
		System.out.println("\n\n\n Inside getAllProfile() in HIbernate DB");
		
		Transaction t = session5.beginTransaction();
		
		Query query = session5.createQuery("from ProfileRegisterer");
		
		System.out.println("\n\n\nQuery executed sucessfully");
		
		//System.out.println("\n\n\n data in query : " + query);
		
		
		
		List lists = (List<Object[]>)query.list();
		
		System.out.println("\n\n\n Querys is converted into list");
		
		//for(List[] list : lists )
		{
			
			System.out.println("\n\n\n   ***PRINTING LIST[0] PROFILE ***" +lists);
		}
		
		//System.out.println("Profiles : " + lists);
		
		t.commit();
		
		//return lists;
		
	}
	
	
}
