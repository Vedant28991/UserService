package com.springboot.service;

import java.util.List;

import com.springboot.entity.User;

public interface UserService {

	void save(User user);

	List<User> getAllUsers();

	boolean check(User user);

	List<User> findByName(String name);

}
