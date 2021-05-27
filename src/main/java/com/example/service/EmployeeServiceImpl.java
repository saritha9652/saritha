package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.beans.Employee;
import com.example.beans.Project;
import com.example.exception.EmployeeException;
import com.example.repository.EmployeeDAO;
import com.example.repository.ProjectDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	//EmployeeDAO emp=new EmployeeDAO();
	@Autowired
	private EmployeeDAO emp;
	@Autowired
	private ProjectDAO projectDAO;
	public Employee addEmployee(Employee e) throws EmployeeException {
		// TODO Auto-generated method stub
		if(!emp.findById(e.getEmpid()).isPresent())
			return emp.save(e);
		else
			throw new EmployeeException("id already exists");
		
		}
	public boolean deleteEmployee(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		if(emp.findById(id).isPresent()) {
			emp.deleteById(id);
		return true;
		}else {
			throw new EmployeeException("does not exists");
		}
	}

	public Employee updateEmployee(Employee e,int id) throws EmployeeException {
		// TODO Auto-generated method stub
		if(emp.findById(id).isPresent()) 
			return emp.saveAndFlush(e);
		else 
			throw new EmployeeException("does not exists");
		
	}
	public List<Employee> displayEmployee(){
	/*	finding salary greater than 50000 using filter
	 * List<Employee> list=emp.findAll();
		List<Employee> l=list.stream().filter(e->e.getSalary()>50000).collect(Collectors.toList());
		return l; */
		return emp.findAll();
	}

	public Employee searchEmployee(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		if(emp.findById(id).isPresent())
			return emp.findById(id).get();
		else
			throw new EmployeeException("does not exists");
	}
	
	public List<Project> displayProject(){
		return projectDAO.findAll();
	}
	
}
