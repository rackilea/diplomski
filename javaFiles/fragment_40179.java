<%@ page import ="java.util.Date" %><%--Imports date --%>
<% Date date = new Date();
   String strdate = date.toString();//could be formatted using SimpleDateFormat.
%>

  <!--must be inside a form -->  
  <input type="text" value="javascript:showDate('<%=strdate%>');"/>

  <!--must be inside a table-->
  <td>javascript:showDate(<%=strdate%>);</td>