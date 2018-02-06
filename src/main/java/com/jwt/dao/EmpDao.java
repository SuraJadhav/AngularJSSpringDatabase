package com.jwt.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.app.pojo.Employee1;
import com.jwt.model.Employee1;
@Repository
@Transactional
public class EmpDao {
	
	@Autowired
	public  SessionFactory sessionfactory;
	
	public void addEmployee(Employee1 emp)
	{
		sessionfactory.getCurrentSession().saveOrUpdate(emp);
	}
	
	public List<Employee1> getAllemployee()
	{
		
		System.out.println("request to get employee details");
		return sessionfactory.getCurrentSession().createQuery("from Employee1").list();
	}


}
