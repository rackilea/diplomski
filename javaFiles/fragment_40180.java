<%--Imports java packages --%>
<%@ page import ="java.util.Date" %>
<%@ page import ="java.text.SimpleDateFormat"%>

<%-- Java code --%>
<% Date date = new Date();
   Calendar calendar = Calendar.getInstance(TIME_ZONE).setTime(date);
   SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
   String strdate = sdf.format(calendar.getTime());
%>

<html>
 <body>
 <!-- Does not need to use javascript. All work is done on the server side.-->
 <table>
   <tr>
     <td><%=strdate%></td>
   </tr>
 </table>
 </body>
</html>