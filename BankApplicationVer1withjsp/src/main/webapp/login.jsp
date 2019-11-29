<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LOGIN</title>
</head>
<style type="text/css">
.error{
    color:red;
    font-family: Calibri;
    font-style: italic;
}
body {
	background-color: #efefef;
}
</style>
<body>

<center>${error }</center>
	<br /> <center>${message }</center>
	<br />
	<form:form action="loginprocessing" method="post" modelAttribute="accountReq">
		<center>
			<table border="1">
				<tr>
				<td>userName:</td>
				<td><input type="text" name="email" value=" "></td>
				</tr>
				<tr>
				<td>password:</td>
			
				<td><input type="password" name="password" value="" ></td>
					</tr>
					<tr>
					<td colspan='2'><input name="submit" type="submit" value="login"/>
					</td>
					</tr>
					
			</table>
			<%-- <input name="${_csrf.parameterName }" type="hidden" value="${_csrf.token}"/> --%>
		</center>
		

	</form:form>











</body>
</html>