<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>List Employees</title>
<meta charset="UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="<c:url value='/assets/css/component.css' />"
	rel="stylesheet" />
<link type="text/css" href="<c:url value='/assets/css/demo.css' />"
	rel="stylesheet" />
<link type="text/css" href="<c:url value='/assets/css/normalize.css' />"
	rel="stylesheet" />
<link type="text/css" href="<c:url value='/assets/css/style.css' />"
	rel="stylesheet" />
</head>
<body>
	<h1>List Employees</h1>
	<table>
		<caption>Show All Employee</caption>
		<thead>
			<tr>
			    <td>NAME</td>
				<th scope="col">Joining Date</th>
				<th scope="col">Salary</th>
				<th scope="col">Employee code</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.name}</td>
				<td>${employee.joiningDate}</td>
				<td>${employee.salary}</td>
				<td><a
					href="<c:url value='/edit-${employee.employeeCode}-employee' />">${employee.employeeCode}</a></td>
				<td><a href="<c:url value='/delete-${employee.id}-employee' />">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<h1>
		<a href="<c:url value='/new' />">Add New Employee</a>
	</h1>

</body>
</html>