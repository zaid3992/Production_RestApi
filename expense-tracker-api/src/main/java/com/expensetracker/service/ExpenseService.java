package com.expensetracker.service;

import java.util.List;

import com.expensetracker.entity.Expense;

public interface ExpenseService {
	List<Expense> getAllExpenses();
	Expense getExpensesById(Long id);
	void deleteExpensesById(Long id);
	Expense saveExpensesDetail(Expense expense);
	Expense updateExpensesDetail(Long id,Expense expense);
}
