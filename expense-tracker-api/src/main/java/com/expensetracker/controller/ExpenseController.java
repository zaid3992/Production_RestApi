package com.expensetracker.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.entity.Expense;
import com.expensetracker.service.ExpenseService;

import jakarta.validation.Valid;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses(Pageable page) {
		return expenseService.getAllExpenses(page).toList();
	}
	
	@GetMapping("/expenses/{id}")//path variable
	public Expense getExpenseById(@PathVariable Long id) {
		return expenseService.getExpensesById(id);
		
	}
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/expenses")//query string
	public void deleteExpenseById(@RequestParam("id") Long id) {
		expenseService.deleteExpensesById(id);
		
	}
	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/expenses")
	public Expense saveExpenseDetail(@Valid @RequestBody Expense expense) {
		return expenseService.saveExpensesDetail(expense);
		
	}
	
	@PutMapping("/expenses/{id}")
	public Expense updateExpenseDetail(@PathVariable Long id, @RequestBody Expense expense) {
		return expenseService.updateExpensesDetail(id, expense);
	}
	
	@GetMapping("/expenses/category")
	public List<Expense> getExpensesByCategory(@RequestParam String category,Pageable page) {
		return expenseService.readByCategory(category,page);
	}
	
	@GetMapping("/expenses/name")
	public List<Expense> getExpensesByName(@RequestParam String keyword,Pageable page) {
		return expenseService.readByName(keyword,page);
	}
	
	@GetMapping("/expenses/date")
	public List<Expense> getExpensesByDates(@RequestParam(required = false) Date startDate,
											@RequestParam(required = false) Date endDate,
											Pageable page) {
		return expenseService.readByDate(startDate,endDate,page);
	}
}
