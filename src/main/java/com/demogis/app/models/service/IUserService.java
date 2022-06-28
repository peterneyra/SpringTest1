package com.demogis.app.models.service;

import java.util.List;

import com.demogis.app.models.entity.User;

public interface IUserService {
	
	public List<User> listUsers();
	
	public void save(User user);
	
	public User findUser(Long id);


}
