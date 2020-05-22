<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<title>View Employee</title>
<style>
td
{
 padding: 12px 20px;
    margin: 8px 0;
}
th
{
 padding: 12px 20px;
    margin: 8px 0;
}
</style>
</head>

<body style="background-color:powderblue;">
<%@ include file="MenuBar.jsp" %>
<%@ page import="in.idk.service.ViewEmployee" %> 
<%@ page import="java.util.List" %>
<%@ page import= "in.idk.model.Employee" %>
<table border="1">
<tr>
<th width="119"><label>Employee_Name</label></th>
<th width="168"><label>Employee_Contact_No.</label></th>
<th><label></label></th>
</tr>

<%
                     ViewEmployee viewEmployee = new ViewEmployee();
                     List<Employee> list = viewEmployee.getListOfEmployees();

                             for (Employee e : list) {
                 %>
                 <tr>
                     <td ><%=e.getEmployeeName()%></td>
                     <td ><%=e.getEmployeeContactNo()%></td>

                     <td><a name="view" href="GetOneEmployee?id=<%=e.getId() %>">View</a></td>

                 </tr>
                 <%}%>




</table>
</body>
</html>