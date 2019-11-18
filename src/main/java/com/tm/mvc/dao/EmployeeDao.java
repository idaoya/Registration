package com.tm.mvc.dao;

import java.util.List;
import com.tm.mvc.model.Employee;

public interface EmployeeDao {

	Employee findById(int id);

	void saveEmployee(Employee employee);
	
	void deleteEmployeeByEmployeeCode(String ssn);
	
	List<Employee> findAllEmployees();

	Employee findEmployeeByEmployeeCode(String ssn);

}
