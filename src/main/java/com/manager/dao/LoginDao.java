package com.manager.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manager.model.LoginDetails;
import com.manager.util.HibernateUtil;

@Component
public class LoginDao {

	private Session session;
	@Autowired
	private LoginDetails detailsObj;

	public boolean validate(String username, String password) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();		
			
			detailsObj = (LoginDetails) session.createQuery("FROM LoginDetails ld WHERE ld.username = :username").setParameter("username", username)
					.uniqueResult();

			if (detailsObj != null && detailsObj.getPassword().equals(password)) {
				return true;
			}		
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("LoginDao Exception!!");	
		}
		return false;
	}
	
}
