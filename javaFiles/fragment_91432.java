<%@ page import="java.sql.*" %><%@ page import="java.io.*" %>
<?xml version="1.0"?>
<tours>
    <%
    Connection connection = null;
    Statement statement = null;
    ResultSet result = null;

try {
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tours", "root", "");
    out.println("connected to database");
}
catch(SQLException e) {
    e.printStackTrace(e);
}
%>
</tours>