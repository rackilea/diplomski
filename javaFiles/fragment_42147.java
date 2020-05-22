<%
 controller.fetch_user obj = new controller.fetch_user();
JSONArray getArray = obj.get_user();
%>
<table>
<tr><td>Email</td><td>Password</td></tr>



<%
  for(int i = 0; i < getArray.size(); i++){
  JSONObject userInfo = getArray.getJSONObject(i);
%>
<tr>
  <td><%=userInfo.get("Email")%><td>
  <td><%=userInfo.get("Password")%><td>
</tr> 
<%
 }
%>

</table>