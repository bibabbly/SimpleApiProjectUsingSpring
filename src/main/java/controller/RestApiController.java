package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import model.Employee;
import service.EmployeeService;

public class RestApiController {
	@Autowired 
	 private EmployeeService employeeService;
//	 
//	api for populate to jqgrid
	@GetMapping("/loadUser")
	public List<Employee> getUsers(){
		return employeeService.getAllUsers();
	}

}
