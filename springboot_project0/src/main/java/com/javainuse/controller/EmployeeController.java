package com.javainuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.javainuse.model.Employee;
import com.javainuse.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/add/employee")
	public Employee addEmployee(@RequestParam("name") String name, @RequestParam("empId") String empId) {

		return employeeService.createEmployee(name, empId);

	}

	@RequestMapping("/remove/employee")
	public String removeEmployee( @RequestParam("empId") String empId) {

		employeeService.deleteEmployee(empId);

		return "Employee removed";
	}

}