package com.tm.mvc.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tm.mvc.model.Employee;

@Repository
public interface EmployeeService {

	Employee findById(int id);
	
	void saveEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployeeByEmployeeCode(String ssn);

	List<Employee> findAllEmployees(); 
	
	Employee findEmployeeByEmployeeCode(String id);

	boolean isEmployeeSsnUnique(Integer id, String ssn);
	
}
