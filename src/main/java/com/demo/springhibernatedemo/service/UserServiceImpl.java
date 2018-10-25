package com.demo.springhibernatedemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springhibernatedemo.dao.UserDao;
import com.demo.springhibernatedemo.entity.User;

@Service

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	
	@Transactional(
			//readOnly=true,
			//timeout=500,
			rollbackFor=Exception.class,
			propagation=Propagation.REQUIRED
			)
	public void saveAndUpdate(User user) throws Exception{
		userDao.save(user);
		System.out.println("after save");
		user.getAddress().setCity("calcutta");
		userDao.update(user);
	}

}