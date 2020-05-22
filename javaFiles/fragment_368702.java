<%
  ConnectSqlDB();
  ConnectExcelDB();
  getRowcount();
  getExcelValues();
%>

<p>Total Records : <%=RowCount%>
<p>Array element at 0 index <%=name[0]%>

<%
 for(String v:name)
 {
   out.println("<br/>" + v);
 }
%>