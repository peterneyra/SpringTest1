package com.demogis.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.demogis.app.models.entity.User;

public interface IUserDao extends CrudRepository<User, Long> {
	


}
