<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.javabykiran.entity.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%  
 String msg=(String)request.getAttribute("msg");
 out.println(msg);
%>
<body>
<center>

<form action="adduser">
<table border=1>
<tr>
  <td> Enter Name</td>
    <td><input type="text" name="name"></td>
</tr>
<tr>
  <td> Enter Address</td>
    <td><input type="text" name="address"></td>
</tr>
<tr>
  <td> Enter Contact</td>
    <td><input type="text" name="contact"></td>
</tr>
<tr>
  <td> Enter Username</td>
    <td><input type="text" name="username"></td>
</tr>
<tr>
 <td><input type="submit" value="save"></td>
</tr>

</table>

</form>
</center>
</body>
</html>