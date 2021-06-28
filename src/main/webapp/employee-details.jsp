<%@page import="com.manager.service.RestClient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.manager.service.RestClient"%>
<%@ page import="com.manager.model.Employee"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<style>
fieldset.scheduler-border {
    border: 3px groove #ddd !important;
    padding: 0 1.4em 1.4em 1.4em !important;
    margin-top: 20px;
    -webkit-box-shadow:  0px 0px 0px 0px #000;
            box-shadow:  0px 0px 0px 0px #000;
}

legend.scheduler-border {
    width:inherit; /* Or auto */
    padding:0 10px; /* To give a bit of padding on the left and right */
    border-bottom:none;
}

.two_buttons{
	align-items: right;
}

</style>
</head>


<body>
	<nav class="navbar"
		style="background-color: #B7CFDC; border: 2px solid #6AABD2;">
		<span class="navbar-brand mb-0 h1"
			style="font-color: #6AABD2; font-size: 15px">Welcome
			${username}!</span> <a href="logout">Logout</a>
	</nav>

	<div class="container-fluid">
		<fieldset class="scheduler-border">
			<legend class="scheduler-border">Employee Listings</legend>

			<div class="mt-3 p-4 d-flex mx-30x two_buttons">
				<form action="upload">
					<input class="mr-2" type="submit" name="updateEmployee"
						value="Upload Employee Details" />
				</form>

				<form action="download/customers.xlsx">
					<input class="mr-2" type="submit" name="downloadEmployee"
						value="Download Employee Details" />
				</form>
			</div>

			<div class="container-fluid" style="align-content: center">
				<table class="table table-bordered table-condensed">
					<thead>
						<tr>
						
							<th>Employee Code</th>
							<th>Employee Name</th>
							<th>Email</th>
							<th>Location</th>
							<th>Date of Birth</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<%!int empCode;
						
	String empName;
	String email;
	String location;
	String dateOfBirth;%>
						<%
						List<Employee> empList = RestClient.getAllEmployees();
						for (Employee employee : empList) {
							
							dateOfBirth = employee.getdOB();
							email = employee.getEmail();
							empCode = employee.getEmpCode();
							empName = employee.getEmpName();
							location = employee.getLocation();
							
						%>
						<tr>
					      
							<td><%=empCode%></td>
							<td><%=empName%></td>
							<td><%=email%></td>
							<td><%=location%></td>
							<td><%=dateOfBirth%></td>
							<td><a href="edit?empCode=<%=empCode%>">Edit</a></td>

						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</fieldset>
	</div>


	<div class="footer"
		style="position: fixed; width: 100%; bottom: 0; background-color: #B7CFDC;">
		<p></p>
	</div>
</body>
</html>