package com.demo.springhibernatedemo.dao;

import java.util.List;

import com.demo.springhibernatedemo.entity.Department;
import com.demo.springhibernatedemo.entity.User;

public interface UserDao {
	    public void save(User user);
	    public void update(User user) throws Exception;
	    public void delete(User user);
	    public User getEmployeeById(int id);
	  	public List<User> list() ;
	  	public List<User>  getUserByCity(String city);	
	    public List<Object[]> getUsergroupByAddress();
	    public List<Department> getDepartments();
}
