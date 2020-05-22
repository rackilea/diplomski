<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,stack.filter.JDBCConnector" %>  
<%
Connection con = null;
try {
    con = JDBCConnector.connect_database();
    System.err.println("Database Connected..");

    Statement stmt = con.createStatement();
    String status = request.getParameter("status");
    String email = request.getParameter("email");
    int i= stmt.executeUpdate("UPDATE assignment SET status='"+status+"' where email='"+email+"'");
    if(i==1){
        out.println("Successfully updated the status");
    }

} catch (Exception e) {
    e.printStackTrace();
}finally{
    con.close();
}
%>