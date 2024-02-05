package com.expensetracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.dto.UserModel;
import com.expensetracker.entity.User;
import com.expensetracker.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody UserModel userModel) {
		return new ResponseEntity<User>(userService.createUser(userModel),HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser( @PathVariable Long id) {
		return new ResponseEntity<User>(userService.read(id),HttpStatus.OK);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@RequestBody UserModel user,@PathVariable Long id) {
		return new ResponseEntity<User>(userService.update(user,id),HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

}
