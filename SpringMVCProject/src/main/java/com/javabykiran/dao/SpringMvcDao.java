package com.javabykiran.dao;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javabykiran.entity.User;

@Repository
public class SpringMvcDao {

	@Autowired
	SessionFactory sessionfactory;
	
	public boolean checkloginpage(User user) {
		// TODO Auto-generated method stub
		String username=user.getUsername();
		String name=user.getName();
		Session session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("name", name));
		List<User>listuser=criteria.list();
		if(!listuser.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
		
		
	}

	public List<User> getuser() {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		
		Criteria criteria=session.createCriteria(User.class);
		List<User>listuser=criteria.list();
		System.out.println(listuser);
		
		return listuser;
	}

	public Boolean deleteUser(int userid) {
		// TODO Auto-generated method stub
		
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		//userid=2 --name,address,contact
		User user=session.get(User.class, userid);
		session.delete(user);
		
		
		transaction.commit();
		return true;
	}

	public List<User> getUser(int userid) {
		// TODO Auto-generated method stub
		
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(User.class);
		criteria.add(Restrictions.eq("id", userid));
	  List<User>listuser=criteria.list();
	  
		return listuser;
	}

	public boolean updateuser(User user) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(user);
		transaction.commit();
		
		return true;
	}

	public boolean adduser(User user) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Transaction transaction=session.beginTransaction();
		Criteria criteria=session.createCriteria(User.class);
		List<User>listuser=criteria.list();
		boolean count = false;
		for(User uservalue:listuser) {
			if(uservalue.getName().equals(user.getName())) {
				count=true;
			}
		}
		if(count==false) {
			session.save(user);
			transaction.commit();
		}
		
		
		return true;
	}

}
