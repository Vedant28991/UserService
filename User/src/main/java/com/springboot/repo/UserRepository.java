package com.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByUserNameContaining(String name);
	
	List<User> findByUserName(String name);
	
	User findByUserNameAndPassword(String name,String pwd);
	
}
