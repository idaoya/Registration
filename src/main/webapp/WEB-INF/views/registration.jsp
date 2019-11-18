<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Add New Customer</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="<c:url value='/assets/css/style.css' />"
	rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
</head>
<body>

	<h1>Add New Customer</h1>

	<form:form method="POST" modelAttribute="employee">
		<form:input type="hidden" path="id" id="id" />
		<table>
			<tr>
				<td><label for="name">Name: </label></td>
				<td><form:input path="name" id="name" maxLength="30" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="joiningDate">Joining Date: </label></td>
				<td><form:input path="joiningDate" id="joiningDate"
						maxLength="10" /></td>
				<td><form:errors path="joiningDate" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="salary">Salary: </label></td>
				<td><form:input path="salary" id="salary" maxLength="8" /></td>
				<td><form:errors path="salary" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="employeeCode">Employee Code: </label></td>
				<td><form:input path="employeeCode" id="employeeCode"
						maxLength="5" /></td>
				<td><form:errors path="employeeCode" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><c:choose>
						<c:when test="${edit}">
							<button type="submit">Update</button>
						</c:when>
						<c:otherwise>
							<button type="submit">Register</button>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</table>
	</form:form>
	<br />
	<br />

	<h1>
		<a href="<c:url value='/list' />">List of All Employees</a>
	</h1>

</body>
</html>