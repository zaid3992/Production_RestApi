package com.expensetracker.service;

import java.util.List;

import com.expensetracker.entity.Expense;

public interface ExpenseService {
	List<Expense> getAllExpenses();
}
