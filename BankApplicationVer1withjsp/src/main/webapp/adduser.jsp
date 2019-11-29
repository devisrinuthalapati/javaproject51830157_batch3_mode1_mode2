<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddAccount</title>
<style type="text/css">
.errors{
		color:red;
		font-family: Calibri;
		font-style: italic;
	}
</style>
</head>

<body>
	<center>
		<h1>welcome ${user.email}</h1>
	</center>
	<center>
		<form:form action="adduser" method="post" modelAttribute="user">

Enter name:<form:input path="name"/><form:errors path="name" class="errors"/>
Enter email:<form:input path="emial"/><form:errors path="email" class="errors"/>
Enter password:<form:input path="password"/><form:errors path="password" class="errors"/>
Enter address:<form:input path="address"/><form:errors path="address" class="errors"/>
Enter role:<form:input path="role"/><form:errors path="role" class="errors"/>

<center>
<input type="submit"/>

</center>
		</form:form>
	</center>
	

</body>
</html>

