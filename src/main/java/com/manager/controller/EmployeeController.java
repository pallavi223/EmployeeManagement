package com.manager.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.compress.utils.IOUtils;

import com.manager.model.Employee;
import com.manager.service.ExcelFileExporter;
import com.manager.service.RestClient;
/*
 * This class will controll all the employee related operations
 */
@Controller
public class EmployeeController {

	/*
	 * This will open edit page and display the entered values
	 */
	
	@RequestMapping(value="/edit")
	public ModelAndView editEmployee(HttpServletRequest request, HttpServletResponse response) {

		Employee empObj = new Employee();
		int employeeCode = Integer.parseInt(request.getParameter("empCode"));	
		System.out.println("Employee Code = "+employeeCode);

		List<Employee> empList = RestClient.getAllEmployees();
		for (Employee employee : empList) {
			if(employee.getEmpCode() == employeeCode) {
				empObj = employee;
				break;
			}
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("edit-employee-details");
		mv.addObject("empObject", empObj);	//passing employee object to edit-employee-details

		return mv;	
	}

	/*
	 * This function will get all the updated employee details and update it
	 */
	@RequestMapping("/save-employee")
	public ModelAndView updateEmployee(HttpServletRequest request, HttpServletResponse response) {
		//int id=Integer.parseInt(request.getParameter("id"));
		int empCode = Integer.parseInt(request.getParameter("empCode"));
		String empName = request.getParameter("empName");
		String location = request.getParameter("location");
		String email = request.getParameter("email");
		String dateOfBirth = request.getParameter("dateOfBirth");

		Employee empObj = new Employee(empCode, empName, location, email, dateOfBirth);
		RestClient.updateEmployee(empObj);	//This will update the details in the api

		ModelAndView mv = new ModelAndView();
		mv.setViewName("employee-details");	//after updating the details the program comes on to the employee-details page
		
		return mv;		
	}


	/*
	 * This function will open upload employee page
	 */
	@RequestMapping("/upload")
	public ModelAndView uploadEmployee(HttpServletRequest request, HttpServletResponse response) {	
		ModelAndView mv = new ModelAndView("upload-employee");
		return mv;		
	}	
	
	/*
	 * This will add a new employee object to the api
	 */
	@RequestMapping("/add-employee")
	public ModelAndView addEmployee(HttpServletRequest request, HttpServletResponse response) {
		//int id=Integer.parseInt(request.getParameter("id"));
		int empCode = Integer.parseInt(request.getParameter("empCode"));
		String empName = request.getParameter("empName");
		String location = request.getParameter("location");
		String email = request.getParameter("email");
		String dateOfBirth = request.getParameter("dateOfBirth");
System.out.println(empCode);
System.out.println(empName);
		Employee empObj = new Employee(empCode, empName, location, email, dateOfBirth);
		RestClient.saveEmployee(empObj);

		ModelAndView mv = new ModelAndView("employee-details");
		return mv;		
	}	
	
	
	@RequestMapping("/download/customers.xlsx")
	public void downloadCsv(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=customers.xlsx");
		ByteArrayInputStream stream = ExcelFileExporter.contactListToExcelFile(RestClient.getAllEmployees());
		IOUtils.copy(stream, response.getOutputStream());
	}
	
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView("index");
		return mv;	
		
	}
	
	
}
