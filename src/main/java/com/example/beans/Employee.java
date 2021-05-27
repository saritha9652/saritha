package com.example.beans;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class Employee {
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int empid;
	@Column(name="empname")
	private String empname;
	@Column(name="department")
	private String department;
	@Column(name="salary")
	private int salary;
	
	@OneToMany(mappedBy="employee")
	private List<Project> project;
	
	
	
}
