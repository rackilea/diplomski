<%@ page language="java" import="java.sql.*" errorPage="" %>

<%
String Id=request.getParameter("Id");
try
{
  Class.forName("com.mysql.jdbc.Driver");
  Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcxyz?autoreconnect=true","username","password");
  Statement st = con.createStatement();
  ResultSet rs=st.executeQuery("select display_name from product where id = "+Id);
  while (!rs.isLast())
  {
    if (rs.next())
    {
      String msg=rs.getString(1);
      out.println(msg);
    }
    else { out.println("No Records Found");}
  }
}
catch(Exception e)
{
  Exception ex = e;
  out.println(e.toString()+"\nDatabase Connection Not Found.");
}
%>