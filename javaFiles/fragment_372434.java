<%
for(int i = 0; i < array.length; i++)
{
%>
<input type="checkbox" name="<%= array[i]%>">
<br/>
<%
}
%>