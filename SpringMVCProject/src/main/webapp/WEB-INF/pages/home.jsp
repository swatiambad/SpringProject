<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.ArrayList" %>
   <%@ page import="com.javabykiran.entity.User" %> 
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ArrayList<User> userlist=(ArrayList<User>)request.getAttribute("list"); %>
<%  
 String msg=(String)request.getAttribute("msg");
 out.println(msg);
%>

	
	<center>
	<h2>User List</h2>
	
	<table border="1">
	
	
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Address</th>
		<th>Contact</th>
		<th>Username</th>
		<th>Actions</th>
	  <th><a href="/adduserpage">Add User </a></th>
	</tr>                                                
	<%
	
	for(User user:userlist)
	{
		
	
	
	%>
	<tr>
		<td><%out.println(user.getId()); %></td>
		<td><%out.println(user.getName()); %></td>
		<td><%out.println(user.getAddress()); %></td>
		<td><%out.println(user.getContact()); %></td>
		<td><%out.println(user.getUsername()); %></td>
		<td><a href="updateuser?id=<%=user.getId() %> ">Update </a> </td>
		<td><a href="deleteuser?id=<%=user.getId() %> ">Delete </a></td>
	
	</tr>
	<%
	}
	%>
	</table>
	  
	</center>
	
</body>
</html>