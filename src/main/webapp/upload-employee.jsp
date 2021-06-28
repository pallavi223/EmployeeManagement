<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload New Employee</title>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<style>
.col-25 {
	float: left;
	width: 20%;
}

.col-75 {
	float: left;
	width: 75%;
}

.md-textarea {
	width: 50%;
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 2px;
	resize: vertical;
	max-width: 280px;
}

input[type=text], input[type=email] {
	width: 50%;
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 2px;
	resize: vertical;
	max-width: 280px;
}

.form {
	align-items: center;
}

fieldset.scheduler-border {
	border: 3px groove #ddd !important;
	padding: 0 1.4em 1.4em 1.4em !important;
	margin-top: 20px;
	-webkit-box-shadow: 0px 0px 0px 0px #000;
	box-shadow: 0px 0px 0px 0px #000;
}

legend.scheduler-border {
	width: inherit; /* Or auto */
	padding: 0 10px; /* To give a bit of padding on the left and right */
	border-bottom: none;
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

	<div class="d-md-flex h-100 form">
		<div class="container-fluid">
			<fieldset class="scheduler-border">
				<legend class="scheduler-border">Employee Listings</legend>
				<!-- Form Begins -->
				<form action="add-employee">
				
					<div class="row form-group">
						<div class="col-25">
							<label for="empCode" class="col-form-label">Employee
								Code: </label>
						</div>
						<div class="col-75">
							<input type="text" class="form-control" id="empCode"
								name="empCode" pattern=".{,100}" required>
						</div>
					</div>

					<div class="row form-group">
						<div class="col-25">
							<label for="empName" class="col-form-label">Employee
								Name: </label>
						</div>
						<div class="col-75">
							<input type="text" class="form-control" id="empName"
								name="empName" pattern=".{,100}" required>
						</div>
					</div>

					<div class="row form-group">
						<div class="col-25">
							<label for="location" class="col-form-label">Location: </label>
						</div>
						<div class="col-75">
							<textarea id="location" class="md-textarea form-control" rows="3"
								name="location" required></textarea>
						</div>
					</div>

					<div class="row form-group">
						<div class="col-25">
							<label for="email" class="col-form-label">Email: </label>
						</div>
						<div class="col-75">
							<input type="email" class="form-control" id="email" name="email"
								pattern=".{,100}" required>
						</div>
					</div>

					<div class="row form-group">
						<div class="col-25">
							<label for="dateOfBirth" class="col-form-label">Date of
								Birth: </label>
						</div>
						<div class="col-75">
							<input type="text" class="form-control" id="dateOfBirth"
								name="dateOfBirth" required>
						</div>
					</div>

					<div class="row form-group">
						<div class="col">
							<input class="btn btn-primary p-2 px-lg-3 btn-lg mt-3"
								type="submit" value="Save"> <input
								class="btn btn-danger p-2 px-lg-4 btn-lg mx-4 mt-3" type="reset"
								value="Cancel">
						</div>
					</div>
				</form>
				<!-- Form Ends -->
			</fieldset>
		</div>
	</div>

	<div class="footer"
		style="position: fixed; width: 100%; bottom: 0; background-color: #B7CFDC;">
		<p></p>
	</div>

</body>
</html>