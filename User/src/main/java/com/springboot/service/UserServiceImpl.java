package com.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public boolean check(User user) {
		
		String nm=user.getUserName();
		String pwd=user.getPassword();
		
		User un=userRepository.findByUserNameAndPassword(nm,pwd);
		
		if(un==null) {
			return false;
		}
		
		return true;
	}

	@Override
	public List<User> findByName(String name) {
		List<User> uList=new ArrayList<>();
		uList=userRepository.findByUserName(name);
		return uList;
	}
	

}
