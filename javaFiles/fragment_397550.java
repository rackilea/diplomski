<% int id = 1 ; %>
<% for(Files file : files) { %>

  <tr>
    <td><%=id %></td>
    <td><%=file.filedate%></td>
    <td><%=file.filename%></td>
    <td><%=file.username%></td>
    <td><%=file.filestatus%></td>
  </tr>
<% 
id++;
} %>