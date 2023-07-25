<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Contact</title>
</head>
<body>
	<div align="center">
		<h2>Add Contact</h2>
		<form:form action="contacts" method="post" modelAttribute="contact">
			<form:label path="firstName">First Name:</form:label>
			<form:input path="firstName" />
			<br />
			
			<form:label path="lastName">Last Name:</form:label>
			<form:input path="lastName" />
			<br />

			<form:label path="emailId">E-mail:</form:label>
			<form:input path="emailId" />
			<br />

			<form:label path="phoneNumber">Phone Number:</form:label>
			<form:input path="phoneNumber" />
			<br />

			<form:label path="status">Status:</form:label>
			<form:radiobutton path="status" value="active" />Active
			<form:radiobutton path="status" value="inactive" />Inactive<br />

			<form:button>Add</form:button>
		</form:form>
	</div>
</body>
</html>