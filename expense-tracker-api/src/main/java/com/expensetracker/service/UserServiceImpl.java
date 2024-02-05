package com.expensetracker.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.dto.UserModel;
import com.expensetracker.entity.User;
import com.expensetracker.exception.ItemAlreadyExistsException;
import com.expensetracker.exception.ResourseNotFoundException;
import com.expensetracker.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User createUser(UserModel userModel) {
		if (userRepo.existsByEmail(userModel.getEmail())) {
			throw new ItemAlreadyExistsException("User is already registered with this email : "+userModel.getEmail());
		}
		User newuser = new User();
		BeanUtils.copyProperties(userModel, newuser);
		return userRepo.save(newuser);
		
	}

	@Override
	public User read(Long id)  throws ResourseNotFoundException{
		return userRepo.findById(id).orElseThrow(() ->  new ResourseNotFoundException("User not found for the id : "+id));
	}

	@Override
	public User update(UserModel user, Long id) {
		User exitUser = read(id);
		exitUser.setName(user.getName() != null ? user.getName() : exitUser.getName());
		exitUser.setEmail(user.getEmail() != null ? user.getEmail() : exitUser.getEmail());
		exitUser.setPassword(user.getPassword() != null ? user.getPassword() : exitUser.getPassword());
		exitUser.setEmail(user.getEmail() != null ? user.getEmail() : exitUser.getEmail());
		exitUser.setAge(user.getAge() != null ? user.getAge() : exitUser.getAge());
		return userRepo.save(exitUser);
	}

	@Override
	public void delete(Long id) {
		User user = read(id);
		userRepo.delete(user);
	}

}
