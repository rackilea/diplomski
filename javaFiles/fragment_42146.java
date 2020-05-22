<%
 controller.fetch_user obj = new controller.fetch_user();
 obj.get_user();
%>
<table>
<tr><td>Email</td><td>Password</td></tr>
for(UserInfo userInfo:obj){
<%
%>
<tr>
  <td><%=userInfo.getEmail()%><td>
  <td><%=userInfo.getPassword()%><td>
</tr> 
<%
 }
%>

</table>