package com.demogis.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demogis.app.models.dao.IUserDao;
import com.demogis.app.models.entity.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly = true) 
	public List<User> listUsers() {
		return (List<User>) userDao.findAll();
	}

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional(readOnly = true) 
	public User findUser(Long id) {
		return userDao.findById(id).orElse(null);
	}


	
}
