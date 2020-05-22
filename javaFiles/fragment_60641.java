<tr>
    <th>Current Employment status<span style='color: #FF0000; display: inline;'>*</span></th>
    <% if(employmentStatus.equals("Employeed")) {%>
    <td>
        <input type="radio" name="employementStatus" value="<%=employmentStatus %>" checked>Employeed
        <input type="radio" name="employementStatus" value="Not Employeed">Not Employeed<br>
    </td>
    <%}else if(employmentStatus.equals("Not Employeed")){%>  
    <td>
        <input type="radio" name="employementStatus" value="Employeed">Employeed
        <input type="radio" name="employementStatus" value="Not Employeed" checked>Not Employeed<br>
    </td>
    <%}
    %>
</tr>