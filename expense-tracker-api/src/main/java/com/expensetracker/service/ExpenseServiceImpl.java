package com.expensetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.entity.Expense;
import com.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService{

	@Autowired
	private ExpenseRepository expenseRepo;
	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepo.findAll();
	}
	@Override
	public Expense getExpensesById(Long id) {
		Optional<Expense> expense = expenseRepo.findById(id);
		if (expense.isPresent()) {
			return expense.get();
		}
		throw new RuntimeException("Expense is not found for the id "+id);
	}
	@Override
	public void deleteExpensesById(Long id) {
		expenseRepo.deleteById(id);
		
	}
	@Override
	public Expense saveExpensesDetail(Expense expense) {
		return expenseRepo.save(expense);
		 
	}
	@Override
	public Expense updateExpensesDetail(Long id, Expense expense) {
		Expense existingExpense = getExpensesById(id);
		existingExpense.setName(expense.getName() != null ? expense.getName(): existingExpense.getName());
		existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription(): existingExpense.getDescription());
		existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory(): existingExpense.getCategory());
		existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount(): existingExpense.getAmount());
		existingExpense.setDate(expense.getDate() != null ? expense.getDate(): existingExpense.getDate());
		
		return expenseRepo.save(existingExpense);
	}
	

}
