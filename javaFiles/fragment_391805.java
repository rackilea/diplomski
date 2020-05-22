ResultSet rs=stmt.executeQuery(vsql);
while(rs.next())
{
%>
<tr>
<td><%=rs.getString(14)%></td>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2)%></td>   
<td><%=rs.getString(3)%></td>
<td><form action="Followup2.jsp">
<input type="hidden" name="col14" value="<%=rs.getString(14)%>" />
<input type="hidden" name="col1" value="<%=rs.getString(1)%>" />
<input type="hidden" name="col2" value="<%=rs.getString(2)%>" />
<input type="hidden" name="col3" value="<%=rs.getString(3)%>" />
<input type="submit" value="submit">[I][1]
</form></td>
</tr>