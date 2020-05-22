<% 
String integer = request.getParameter("integer"); 
int x = (integer == null ? 0 : (Integer.parseInt(integer) + 1));
%>

<input type="text" name="integer" value="<%=x%>"/>
<input type="submit" value="add one" />