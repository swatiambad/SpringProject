<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
    <%@page import="com.javabykiran.entity.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<% List<User>listuser=(List<User>)request.getAttribute("list"); %>
<body>
<center>
<%
for(User user:listuser)
{
%>
<form action="updateparticularuser">

<table border="1">
<tr>
 <td>Enter name</td>
 <td><input type="text" name="name" value="<% out.println(user.getName()); %>"></td>
</tr>
<tr>
<td>Enter Address</td>
 <td><input type="text" name="address" value="<% out.println(user.getAddress()); %>"></td>
</tr>
<tr>
<td>Contact</td>
 <td><input type="text" name="contact" value="<% out.println(user.getContact()); %>"></td>
</tr>
<tr>
<td>Enter username</td>
 <td><input type="text" name="username" value="<% out.println(user.getUsername()); %>"></td>
 
 <input type="hidden" name="id" value="<% out.println(user.getId()); %>" >
</tr>
<tr>
<td><input type="submit"></td>
</tr>.
</table>
<%
}
%>
</form>


</center>
</body>
</html>