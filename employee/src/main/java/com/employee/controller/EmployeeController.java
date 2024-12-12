package com.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> registerEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
	return  new ResponseEntity<Employee>(service.saveEmployee(employeeDto),HttpStatus.CREATED);
	}
	
	@PostMapping("/employees")
	public List<Employee> registerEmployees(@RequestBody List<Employee> employees) {
	return  service.saveEmployees(employees);
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeUsingId(@PathVariable Long id) {
		return service.getEmployee(id);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeUsingIds(@PathVariable Long id) {
		return new ResponseEntity<Employee>(service.getEmployee(id),HttpStatus.OK);
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmployees() {
		return service.getAllEmp();
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmp(@RequestBody Employee emp,@PathVariable Long id) {
		return service.upDateEmpNumber(emp, id);
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmp(@PathVariable Long  id) {
		return service.deleteEmp(id);
	}
}
