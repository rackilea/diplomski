<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WORLD</title>
</head>
<body>
<%@ page language="java" import="java.sql.*" %>

<%
String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
String DB_URL = "jdbc:mysql://localhost:3306/world";
String USER = "root";
String pass = "informatica";
Connection dbConn = null;
Statement st = null;
ResultSet rs = null;
try
{     
     //Registro il driver del database
    Class.forName(JDBC_DRIVER);
    // Connessione al db tramite il driver
    dbConn = DriverManager.getConnection(DB_URL, USER, pass);
    if(!dbConn.isClosed())
    {
        out.println("Connessione avvenuta con successo a mysql server. . .");
    }
    st = dbConn.createStatement();
    rs = st.executeQuery("SELECT Code,name,continent from country where name like 'i%';");

    String code="";
    String name="";
    String continent="";


    out.println("<h1>ELENCO STATI CON LA I:</h1>");

    while(rs.next())
    {   
        code = rs.getString(1);
        name = rs.getString(2);
        continent = rs.getString(3);                
        out.println("<br><br><b>ID:</b> "+ code + " <br> " + "<b>COUNTRY: </b> "+name+" <br> " + "<b>CONTINENT</b> "+continent+" <br> ");
    }    
}
catch (SQLException e) 
{
    // TODO Auto-generated catch block
    e.printStackTrace();
}
finally 
{   
    try
    {           
        rs.close();           
        st.close();
        dbConn.close();
    }
    catch(SQLException e)
    {
        out.println(e.getMessage());
    }       
}

%>

</body>
</html>