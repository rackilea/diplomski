<form method="post" action="<%=request.getContextPath()%>/TestServlet">
 <table 
 <tr>
   ...
while (rs.next()) {

   int activityid1 = rs.getInt("id");
   String type1 = rs.getString("type");
                ...

   out.println("<tr>");
   out.println("<td>" + activityid1 + "</td>");
   out.println("<td>" + type1 + "</td>");
   out.println("<td><b><font color='#663300'><input type='checkbox' name='ticket' value='"+activityid1+"'/></font></td></b>");

   out.println("</tr>");

 }
 </table>
    <td colspan="10"><input type="submit" value="Submit" /></td>
 </form>