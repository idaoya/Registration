package com.tm.mvc.controller;

import java.util.List;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tm.mvc.model.Employee;
import com.tm.mvc.service.EmployeeService;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	EmployeeService service;
 
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {

		List<Employee> employees = service.findAllEmployees();
		model.addAttribute("employees", employees);
		return "allemployees";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("edit", false);
		return "registration";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		service.saveEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
		return "success";
	}

	@RequestMapping(value = { "/edit-{employeeCode}-employee" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable String employeeCode, ModelMap model) {
		Employee employee = service.findEmployeeByEmployeeCode(employeeCode);
		model.addAttribute("employee", employee);
		model.addAttribute("edit", true);
		return "registration";
	}

	@RequestMapping(value = { "/edit-{employeeCode}-employee" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid Employee employee, BindingResult result, ModelMap model,
			@PathVariable String employeeCode) {

		if (result.hasErrors()) {
			return "registration";
		}

		if (!service.isEmployeeSsnUnique(employee.getId(), employee.getEmployeeCode())) {
			FieldError ssnError = new FieldError("employee", "employeeCode", messageSource.getMessage(
					"non.unique.employee.code", new String[] { employee.getEmployeeCode() }, Locale.getDefault()));
			result.addError(ssnError);
			return "registration";
		}

		service.updateEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName() + " updated successfully");
		return "success";
	}

	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{employeeCode}-employee" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String employeeCode) {
		service.deleteEmployeeByEmployeeCode(employeeCode);
		return "redirect:/list";
	}

  
}
