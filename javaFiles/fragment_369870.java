<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>


     <%
          Statement stmtTableLit = null;
          ResultSet rsTableList = null;
      Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

     if (request.getParameter("schema") != null) {
                    String selectedSchema = request.getParameter("schema");//getting data 
                    stmtTableLit = conn.createStatement();
                    stmtTableLit.execute("use " + selectedSchema);
                    PreparedStatement pstmt = conn.prepareStatement("show tables");
                    rsTableList = pstmt.executeQuery();

                }
   //whatever will be  there in out.println() will be sent back as response to your index.jsp page         
       out.println('<select id="tableName" onchange="sendTable()">
            <option value="null" selected="selected">Choose the Table</option>');

                if (rsTableList != null) {
                    while (rsTableList.next()) {
                        out.println(
                                "<option value=" + rsTableList.getString(1) + ">" + rsTableList.getString(1) + "</option>");
                    }
                    rsTableList.close();
                }

        out.println('</select>');
     %>