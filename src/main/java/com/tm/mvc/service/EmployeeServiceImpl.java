package com.tm.mvc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.tm.mvc.dao.EmployeeDao;
import com.tm.mvc.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public Employee findById(int id) {
		return dao.findById(id);
	}

	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}

	public void updateEmployee(Employee employee) {
		Employee entity = dao.findById(employee.getId());
		if (entity != null) {
			entity.setName(employee.getName());
			entity.setJoiningDate(employee.getJoiningDate());
			entity.setSalary(employee.getSalary());
			entity.setEmployeeCode(employee.getEmployeeCode());
		}
	}

	public void deleteEmployeeByEmployeeCode(String ssn) {
		dao.deleteEmployeeByEmployeeCode(ssn);
	}

	public List<Employee> findAllEmployees() {
		return dao.findAllEmployees();
	}

	public Employee findEmployeeByEmployeeCode(String employeeCode) {
		return dao.findEmployeeByEmployeeCode(employeeCode);
	}

	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee = findEmployeeByEmployeeCode(ssn);
		return (employee == null || ((id != null) && (employee.getId() == id)));
	}

}
