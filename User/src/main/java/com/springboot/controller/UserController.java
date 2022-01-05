package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.User;
import com.springboot.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired 
	UserService userService;
	
	
	@PostMapping("")
	public ResponseEntity<String> saveUser(@RequestBody User user){
		
		userService.save(user);
		
		return new ResponseEntity<String>("Saved Successfully",HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> check(){
		
		List<User> userList=new ArrayList<>();
		userList=userService.getAllUsers();
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user){
		
		boolean exists=userService.check(user);
		
		if(exists==true) {
			return new ResponseEntity<String>("Logged in",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Try Again",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> findByName(@RequestParam String name){
		
		List<User> ulist=userService.findByName(name);
		
		return new ResponseEntity<List<User>>(ulist,HttpStatus.OK);
		
	}
	
}
