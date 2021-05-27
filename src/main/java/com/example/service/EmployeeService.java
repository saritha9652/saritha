package com.example.service;

import java.util.List;

import com.example.beans.Employee;
import com.example.beans.Project;
import com.example.exception.EmployeeException;

public interface EmployeeService {
	public Employee addEmployee(Employee e) throws EmployeeException;
	public boolean deleteEmployee(int id) throws EmployeeException;
	public Employee updateEmployee(Employee e,int id) throws EmployeeException;
	public List<Employee> displayEmployee();
	public Employee searchEmployee(int id) throws EmployeeException;
	public List<Project> displayProject();
	
}
