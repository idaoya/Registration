<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Success</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="<c:url value='/assets/css/style.css' />"
	rel="stylesheet" />
<link href='https://fonts.googleapis.com/css?family=Nunito:400,300'
	rel='stylesheet' type='text/css'>
<meta http-equiv="refresh" content="3; url=/Registration/list">
</head>
<body>
	<h1>
		message : ${success} <br /> <br /> Go back to <a
			href="<c:url value='/list' />">List of All Employees</a>
	</h1>
</body>
</html>