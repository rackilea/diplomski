<%
   String u = "";
   mypack.Conn db = new mypack.Conn();
   ResultSet rs = db.s.executeQuery("select * from login");  // error!
   out.println("<table><th>Username<th>Password<th>type<th>Modify");
  out.println("<table><th>Username<th>Password<th>type<th>Modify"); 
  while (rs.next()) {
%>
<tr>
   <td>
    <%= u%></td>
   <td>
    <%= rs.getString("password")%></td>
   <td>
    <%= rs.getString("type")%></td>
   <td>
    <a href ="modifyuser1.jsp" user ="<%=u%>">Modify</a></td>
</tr>
<% } %>