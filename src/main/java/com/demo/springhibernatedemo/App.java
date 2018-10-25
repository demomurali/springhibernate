package com.demo.springhibernatedemo;

import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.springhibernatedemo.dao.UserDao;
import com.demo.springhibernatedemo.dao.UserDaoImpl;
import com.demo.springhibernatedemo.entity.Address;
import com.demo.springhibernatedemo.entity.User;
import com.demo.springhibernatedemo.service.UserService;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
     	ApplicationContext context =new
				ClassPathXmlApplicationContext("applicationContext.xml");
    // 	UserDao userDao=(UserDao)context.getBean("userDaoImpl");
     	
    	UserService userService=(UserService)context.getBean("userServiceImpl");
     	
     	User user=new User();
     	user.setUserName("rohit");
		user.setDescription("hello23");
		//user.setGender(Gender.female);
		user.setDob(new Date());
		
		Address address=new Address();
		address.setCity("coimbatore");
		address.setPinCode(641012);
		address.setState("Tamil Nadu");
		address.setStreet("kalluri");
		user.setAddress(address);
		//user.setUserId(4);
		
		
		userService.saveAndUpdate(user);
		
		
		//userDao.save(user);
     	
	/*	
     	List<User> users=userDao.getUserByCity("bangalore");
     	users.stream().forEach(
     			user1->{
     					System.out.println(user1.getUserName());
     				});
    //
    	//userDao.delete(user);
    	
    	
    	/*
    	
    	List<Object[]> results=userDao.getUsergroupByAddress();
    results.stream().forEach((object)->{
    			System.out.println(object[0]+" "+object[1]);
    });
    	*/
    }
}