package com.expensetracker.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.expensetracker.entity.Expense;

public interface ExpenseService {
	Page<Expense> getAllExpenses(Pageable page);
	
	Expense getExpensesById(Long id);
	
	void deleteExpensesById(Long id);
	
	Expense saveExpensesDetail(Expense expense);
	
	Expense updateExpensesDetail(Long id,Expense expense);
	
	List<Expense> readByCategory(String category,Pageable page);
	
	List<Expense> readByName(String keyword,Pageable page);
	
	List<Expense> readByDate(Date startDate,Date endDate,Pageable page);
	
}

