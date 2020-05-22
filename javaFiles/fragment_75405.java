ResultSet rs = stmt.executeQuery("select name, title, amount from Postdata"); %>
<table>
    <tbody>
    <% while (rs.next()) {%>
      <tr>
        <td>
          <%=rs.getString("name")%>
        </td>
        <td>
          <%=rs.getString("title")%>
        </td>
        <td>
          <%=rs.getString("amount")%>
        </td>
      </tr>
    <%}%>
</tbody>
</table>