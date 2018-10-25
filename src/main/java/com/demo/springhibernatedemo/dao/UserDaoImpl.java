package com.demo.springhibernatedemo.dao;

import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springhibernatedemo.entity.Department;
import com.demo.springhibernatedemo.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;

	
	
	
	// follow
	@Transactional(propagation=Propagation.REQUIRES_NEW)
     public void save(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println(session.hashCode());
		session.save(p);
		
     }
	// mand vs never
	// support vs not support
	// required vs required new
	//
	@Transactional(propagation=Propagation.MANDATORY)
    public void update(User user) throws Exception {
    	 System.out.println("inside update");
    	 Session session = this.sessionFactory.getCurrentSession();
     System.out.println(session.hashCode());
    
    	 if(true)
    	 		throw new Exception("some");
    	
    	//	Transaction tx = session.beginTransaction();
		session.update(user);
	//	tx.commit();
		//session.close();
	}
    
    public void delete(User user) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
		session.close();
	}

   
    public User getEmployeeById(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user=(User)session.get(User.class,id);
		tx.commit();
		session.close();
		return user;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<User> list() {
		Session session = this.sessionFactory.openSession();
		List<User> userList = session.createQuery("from User").list();
		session.close();
		return userList;
	}
    
    @SuppressWarnings("unchecked")
	public List<User>  getUserByCity(String city){
    		Session session = this.sessionFactory.openSession();
    		Query query = session.getNamedQuery("User.searchByCity");
		query.setString("city", city);
		List<User> users=query.list();
		session.close();
		return users;
    }
		
    @SuppressWarnings("unchecked")
	public List<Object[]> getUsergroupByAddress(){
		Session session = this.sessionFactory.openSession();
		String hql="SELECT u.address.city,count(*) FROM User u "
				+ "group by u.address.city";
		Query query=session.createQuery(hql);
		List<Object[]> list=query.list();
		return list;
     }
    
    @SuppressWarnings("unchecked")
	public List<Department> getDepartments(){
    		Session session = this.sessionFactory.openSession();
    		List<Department> departments = session.createCriteria(Department.class,"department")
				.setFetchMode("employees", FetchMode.JOIN)
				.list();
    			return departments;
    	}
    
 }
