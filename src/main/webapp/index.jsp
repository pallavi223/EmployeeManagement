<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=password], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=submit] {
	width: 15%;
	background-color: White;
	color: black;
	width: 80px;
	border-radius: 50px;
}
</style>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<form action="login" method="post">
		<table align="center" width="600">
			<tr bgcolor="lightblue">
				<td bgcolor="lightblue"></td>
				<td align="middle" bgcolor="lightblue"><b><em><strong><font
								size="6">Login</font></strong></em></b></td>
			</tr>
			<tr>
				<th align="left">UserName:</th>
				<td><font color="red">*</font><input type="text"
					name="username" required></td>
			</tr>
			<tr>
				<th align="left">Password:</th>
				<td><font color="red">*</font><input type="password"
					name="password" required></td>
			</tr>
			<tr>
				<th></th>
				<td colspan="1" align="left"><font color="blue"><a
						href="forget.jsp"> forgot Password?</a></font></td>
			</tr>

			<tr>
				<td colspan="2" align="right" bgcolor="lightblue"><input
					type="submit" value="Log in>>"></td>
		</table>

	</form>
	<br />
	
</body>
</html>