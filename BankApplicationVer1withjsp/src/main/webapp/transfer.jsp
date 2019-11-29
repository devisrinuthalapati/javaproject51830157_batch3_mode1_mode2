<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="from" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
<!-- <style type="text/css">
.errors{
color: red;
font-family: calibri;
font-style: italic;
}
</style> -->
</head>
<body>
<center>
<from:form action="transfer" method="post" modelAttribute="transferformbean">
Enter From Ac.No:<from:input path="fromac" /><%-- <from:errors path="fromac" class=errors/> --%>
Enter To Ac.No:<from:input path="toac" /><%-- <from:errors path="toac" class=errors/> --%>
Enter Amount:<from:input path="amount"/>
<center>
<input type="submit">
</center>
<input name="${_csrf.parameterName }" type="hidden" value="${_csrf.token}"/>
</from:form>
</center>
</body>
</html>