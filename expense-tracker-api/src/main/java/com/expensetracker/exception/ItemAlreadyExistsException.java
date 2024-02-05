package com.expensetracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ItemAlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemAlreadyExistsException(String message) {
		super(message);
	}

	
	

}
