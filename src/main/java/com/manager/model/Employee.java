package com.manager.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class Employee {
//	private int id;

	private int employeeCode;
	private String employeeName;
	private String location;
	private String email;
	private String dateOfBirth;

	public Employee() {
		super();
	}

	public Employee(int empCode, String empName, String location, String email, String dOB) {
		super();
		//this.id = id;
		this.employeeCode = empCode;
		this.employeeName = empName;
		this.location = location;
		this.email = email;
		this.dateOfBirth = dOB;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public int getEmpCode() {
		return employeeCode;
	}

	public void setEmpCode(int empCode) {
		this.employeeCode = empCode;
	}

	public String getEmpName() {
		return employeeName;
	}

	public void setEmpName(String empName) {
		this.employeeName = empName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getdOB() {
		return dateOfBirth;
	}

	public void setdOB(String dOB) {
		this.dateOfBirth = dOB;
	}

	@Override
	public String toString() {
		return "Employee [empCode=" + employeeCode + ", empName=" + employeeName + ", location=" + location + ", email="
				+ email + ", dOB=" + dateOfBirth + "]";
	}

}
