<%
Employee employees[] = (Employee []) request.getAttribute("arr");
for (Employee employee : employees) {
    if (employee == null) {
        continue;
    } %>
<tr><td><b>.</b></td><td><%=employee.getName()%></td><td>
    <%=employee.getLname()%></td><td><%=employee.getType()%></td><td>
    <%=employee.getEmail()%></td><td><a href="">Edit Employee Details</a></td>
</tr>
<%}%>