//to retrieve data in jsp from servlet
<%! String[] staffData;%>
<% retrievedInfo = (ArrayList) request.getAttribute("filledInfo");%>
<% staffData = (String[]) retrievedInfo.get(0);%>

<%
//After establishing connection:
ResultSet rs = stmt.executeQuery("Select * from EDUCATION where STAFF_NO = ' "+staffData[0]+" '   ");


%>

<%
 //then iterate through the resultset...
 while(rs.next()) {
        out.print(rs.getObject(1).toString());
       //...etc..
      }
%>