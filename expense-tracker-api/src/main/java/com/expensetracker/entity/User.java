package com.expensetracker.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@JsonIgnore // this is from jackson api will see that in reponse
	private String password;
	
	private Long age;
	
	@Column(name = "created_at" ,nullable = false,updatable = false)
	@CreationTimestamp  // Hibernate  annotation
	private Timestamp createdAt;
	
	@Column(name = "updated_at")
	@UpdateTimestamp
	private Timestamp updatedAt;
}
