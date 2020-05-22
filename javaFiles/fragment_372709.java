<table>
<%
for ( int i =0; i < timeSize ; i++)
{
out.println(resource[i]);
out.println(itimespend[i]);
out.println(icostspend[i]);
totalcost += itimespend[i] * icostspend[i];     
%>

<tr>
<td> <%=resource[i]%></td>
<td><%=itimespend[i]%> </td>
<td> <%=icostspend[i]%></td>
</tr>

<%       
}
%>

</table>