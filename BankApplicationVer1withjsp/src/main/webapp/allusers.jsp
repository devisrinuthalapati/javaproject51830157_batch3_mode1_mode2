<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table>
			<thead>
				<tr>
					<th>id</th>
					<th>name</th>
					<th>email</th>
					<th>password</th>
					<th>address</th>
					<th>status</th>
					<c:if test="${user.role == 'admin'}">

						<th>update</th>
					</c:if>
				</tr>

			</thead>
			<tbody>
				<c:forEach items="users" var="${user}">
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<td>${user.email}</td>
						<td>${user.password}</td>
						<td>${user.address}</td>
						<td>${user.status}</td>
						<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
					<td><a href="update?id=${user.id }">update</a></td>
					<td><a href="adduser">adduser</a></td>
					<td><a href="deleteuser">"deleteuser"</a></td>
					
					</sec:authorize>
				</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>