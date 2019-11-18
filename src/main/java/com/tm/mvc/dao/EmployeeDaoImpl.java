package com.tm.mvc.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.tm.mvc.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {

	public Employee findById(int id) {
		return getByKey(id);
	}

	public void saveEmployee(Employee employee) {
		persist(employee);
	}

	public void deleteEmployeeByEmployeeCode(String id) {
		Query query = getSession().createSQLQuery("delete from Employee where id = :id");
		query.setString("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria = createEntityCriteria();
		return (List<Employee>) criteria.list();
	}

	public Employee findEmployeeByEmployeeCode(String employeeCode) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("employeeCode", employeeCode));
		return (Employee) criteria.uniqueResult();
	}
}
