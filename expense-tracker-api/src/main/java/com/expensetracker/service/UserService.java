package com.expensetracker.service;

import com.expensetracker.dto.UserModel;
import com.expensetracker.entity.User;


public interface UserService {

	User createUser(UserModel user);
	User read(Long id);
	User update(UserModel user,Long id);
	void delete(Long id);
}
