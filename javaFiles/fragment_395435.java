<% List<Employee> employees = company.getEmployees();
   double sum=0.0;
%>
<table border="1">

    <tr>
        <td>ID</td>
        <td>Name</td>                        
        <td>Salary</td>             
    </tr>        
    <%
for(int i=0; i <employees.size(); i++){
    sum += employees.get(i).getSalary();
%> 
        <tr>      
            <td><%=employees.get(i).getId()%></td>
            <td><%=employees.get(i).getNom()%></td>                
            <td><%=employees.get(i).getSalary()%></td>  
        </tr>
    <% } %>
</table> 

//get the average salary of all employees
<p>Average salary of all employees in this company:<%=sum/(double)employees.size()%> </p>