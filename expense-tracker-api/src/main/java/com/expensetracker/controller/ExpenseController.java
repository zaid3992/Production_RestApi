package com.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.entity.Expense;
import com.expensetracker.service.ExpenseService;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses() {
		return expenseService.getAllExpenses();
	}
	
	@GetMapping("/expenses/{id}")//path variable
	public Expense getExpenseById(@PathVariable Long id) {
		return expenseService.getExpensesById(id);
		
	}
	@DeleteMapping("/expenses")//query string
	public void deleteExpenseById(@RequestParam("id") Long id) {
		expenseService.deleteExpensesById(id);
		
	}
	
	@PostMapping("/expenses")
	public Expense saveExpenseDetail(@RequestBody Expense expense) {
		return expenseService.saveExpensesDetail(expense);
		
	}
	
	@PutMapping("/expenses/{id}")
	public Expense updateExpenseDetail(@PathVariable Long id, @RequestBody Expense expense) {
		return expenseService.updateExpensesDetail(id, expense);
	}
}
