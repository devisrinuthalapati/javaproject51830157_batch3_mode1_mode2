<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AllAccounts</title>
</head>
<body>
	<center>
		<table>
			<thead>
				<tr>
					<th>accountnumber</th>
					<th>balance</th>
					<th>customer</th>
					<c:if test="${user.role == 'mgr'|| 'admin'}">
				
				<th>update</th>
				</c:if>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ accounts}" var="account">
					<tr>
						<td>${account.accountnumber}</td>
						<td>${account.balance}</td>
						<td>${account.customer}</td>
						<sec:authorize access="hasAnyRole('ROLE_MGR''ROLE_ADMIN')">
							<td><a href="update?id=${customer.id}">update</a></td>
							<td><a href="addaccount">addaccount</a></td>
							<td><a href="deleteaccount">deleteaccount</a></td>
						</sec:authorize>
					</tr>
				</c:forEach>

			</tbody>

		</table>

	</center>
	<br />
	<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_CLERK')">
		<center>
			<a href="deposit">deposit</a></br>
			
			<a href="transfer">transfer</a></br>
			
			<a href="withdraw">withdraw</a></br>
		</center>
</sec:authorize>






</body>
</html>