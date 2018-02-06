package com.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.jwt.dao.EmpDao;
import com.jwt.model.Employee1;


@RestController
public class EmpController {
	
	@Autowired
	private EmpDao service;
	
	Gson gson =new Gson();
	
	
	public EmpController()
	{
		System.out.println("request comming in controller");
	}
	
	
	@RequestMapping(value="/")
	public ModelAndView homepage()
	{
		/*System.out.println("inside homepage");
		List<Employee1>listemp=service.getAllemployee();
		for (int i = 0; i < listemp.size(); i++) {
			Employee1 em=listemp.get(i);
			System.out.println("this is the fields"+em.getName());
		}*/
		ModelAndView md=new ModelAndView();
	//	md.addObject("listemp",listemp);
		md.setViewName("Home");
		return md;
	}
	
	@RequestMapping(value="/empDetails",method=RequestMethod.GET,produces="application/json")
	public String GetUserdetails()
	{
		
		System.out.println("through emp detail empdetails");
		List<Employee1> lst=service.getAllemployee();
		String response=gson.toJson(lst);
		System.out.println(response);
		return response;
	}
	
	@RequestMapping(value="/addUser",consumes=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	public ResponseEntity addUser(@RequestBody Employee1 emp)
	{
		
		System.out.println("request come in process user");
		service.addEmployee(emp);
		return new ResponseEntity(HttpStatus.OK);
	}

}
