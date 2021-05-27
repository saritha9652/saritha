package com.example.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.Employee;
import com.example.beans.Project;
import com.example.exception.EmployeeException;
import com.example.service.EmployeeService;

@RestController
public class EmployeeController {
@Autowired
private EmployeeService service;
	@GetMapping("/getEmployees")
	public ResponseEntity<List> getEmployees(){
	/*	List<Employee> e=service.displayEmployee();
		return e;*/
		return new ResponseEntity<List>(service.displayEmployee(),HttpStatus.OK);
	}
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) throws EmployeeException {
	/*	Employee emp = service.addEmployee(e);
		System.out.println(emp);
		return emp;*/
		return new ResponseEntity<Employee>(service.addEmployee(e),HttpStatus.CREATED);
	}
	@GetMapping("searchEmployee/{id}")
	public ResponseEntity<Employee> searchEmployee(@PathVariable int id) throws EmployeeException {
		/*List<Employee> l=new ArrayList<>();
			l =service.searchEmployee(id);
			System.out.println(1);
			return l;*/
		return new ResponseEntity<Employee>(service.searchEmployee(id),HttpStatus.FOUND);
	}
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<Boolean> deleteEployee(@PathVariable int id) throws EmployeeException {
		/*	service.deleteEmployee(id);
			return true;*/
		return new ResponseEntity<Boolean>(service.deleteEmployee(id),HttpStatus.FOUND);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id,@RequestBody Employee e) throws EmployeeException {
		/*int	value = service.updateEmployee(e);
			System.out.println(value);
			return value;*/
		return new ResponseEntity<Employee>(service.updateEmployee(e,id),HttpStatus.OK);
	}
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<Object> handleRuntimeException(HttpServletRequest request, Exception ex){
		System.out.println("Controller based exception");
		System.out.println("RuntimeException Occured:: URL="+request.getRequestURL() +" raised "+ex);
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.NOT_FOUND);	
	}
	@GetMapping("/displayAllProject")
	public ResponseEntity<List<Project>> displayProject(){
	
		return new ResponseEntity<List<Project>>(service.displayProject(),HttpStatus.OK);
	}
}
