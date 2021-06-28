package com.manager.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.manager.model.Employee;


public class RestClient {

	private static final String ROOT_URI = "http://localhost:8088/employees";
	static RestTemplate restTemplate = new RestTemplate();
	
	
	public static List<Employee> getAllEmployees() {				
		ResponseEntity<Employee[]> response = restTemplate.getForEntity(ROOT_URI, Employee[].class);
		return Arrays.asList(response.getBody());
	}
	
	public static Employee getEmployee(int empCode) {
		ResponseEntity<Employee> response = null;
		try {
			String new_url = "http://localhost:8088/employees/{empId}";
			 response = restTemplate.getForEntity(new_url, Employee.class, empCode);
			
		}catch(Exception e) {
			System.out.println("getEmployee() exception");
			e.printStackTrace();
		}
		return response.getBody();
	}	
	
	public static Employee saveEmployee(Employee emp) {
		ResponseEntity<Employee> response = restTemplate.postForEntity(ROOT_URI, emp, Employee.class);
		return response.getBody();
	}
	
	public static void updateEmployee(Employee emp) {
		restTemplate.put(ROOT_URI, emp);
	}
	
	public static void deleteEmployee(int empCode) {
		restTemplate.delete(ROOT_URI + "/" +empCode);
	}
}