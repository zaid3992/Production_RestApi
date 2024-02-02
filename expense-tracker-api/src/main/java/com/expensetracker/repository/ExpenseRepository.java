package com.expensetracker.repository;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensetracker.entity.Expense;




@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	// select * from tbl_expenses where category =?
	Page<Expense> findByCategory(String categoryPag , Pageable page);
	
	// select * from tbl_expenses where name LIKE '%Keyword%'
	Page<Expense> findByNameContaining(String keyword,Pageable page);
	
	// select * from tbl_expenses where date BETWEEN 'startDate' AND 'endDate'
	Page<Expense> findByDateBetween(Date startDate,Date endDate,Pageable page);

}
