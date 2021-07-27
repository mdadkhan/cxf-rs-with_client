package com.khan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.khan.jsonobj.model.Employee;
import com.khan.jsonobj.model.Employees;
import com.khan.jsonobj.model.EmployeesList;
import com.khan.pojo.PersonPojo;



//@Component("helloResourceV1")
public class PersonServiceImpl implements PersonService{
	
	public HashMap<String, PersonPojo> personMap = new HashMap<String, PersonPojo>();

	public PersonPojo fetchPeron(String id) {
		
//		PersonPojo person = new PersonPojo();
//		
//		person.setFirstName("Muazzam");
//		person.setLastName("Khan");
//		person.setAddress("123 Main St, Norton VA, 24273");
		
		return personMap.get(id);
	}
	
	@PostConstruct
	public void doSet() {
	    System.out.println("Info message in Person Service");
	    
		PersonPojo person1 = new PersonPojo();
		
		person1.setFirstName("Muazzam");
		person1.setLastName("Khan");
		person1.setAddress("123 Main St, Norton VA, 24273");
		personMap.put("123", person1);
		
		PersonPojo person2 = new PersonPojo();
		person2.setFirstName("Zafar");
		person2.setLastName("Khan");
		person2.setAddress("456 Main St, Norton VA, 24273");
		personMap.put("456", person2);	

		PersonPojo person3 = new PersonPojo();
		person3.setFirstName("Arsh");
		person3.setLastName("Khan");
		person3.setAddress("789 Main St, Norton VA, 24273");
		personMap.put("789", person3);
	    
	    
	}

	@Override
	public EmployeesList fetchJsonPeron(String id) {
		EmployeesList empsList = new EmployeesList();
		Employees emps = new Employees();
		List<Employee> empList = new ArrayList<Employee>();
		Employee emp = new Employee();
		emp.setId("100");
		emp.setFirstName("Muazzam from Json");
		emp.setLastName("Khan");
		empList.add(emp);
		emps.setEmployee(empList);
		empsList.setEmployees(emps);
		
		return empsList;
	}

	@Override
	public Response postProcessingJsonEmployeee(EmployeesList employeesList) {
		System.out.println("POST Processing Employee: " + employeesList.getEmployees().getEmployee().get(0).getFirstName());
		
		return Response.ok("{\"firstName:\": \"Muazzam\", \"lastName\": \"Khan\"}").build();
	}

}
