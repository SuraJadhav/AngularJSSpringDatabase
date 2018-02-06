package com.jwt.dao;

/*import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Employee;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
@Autowired
private SessionFactory sessionFactory;
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	public void deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		Employee employee=(Employee) sessionFactory.getCurrentSession().load(Employee.class, employeeId);
		if(null != employee)
		{
			sessionFactory.getCurrentSession().delete(employee);
		}
	}
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
	sessionFactory.getCurrentSession().update(employee);
	return employee;
	}

	public Employee getEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, employeeId);
	}

}*/
