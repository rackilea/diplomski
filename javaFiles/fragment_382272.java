<%@ page import="java.util.* , javax.sql.* , java.sql.*" %>
<% 
Connection con = null;
java.sql.Statement s = null;
java.sql.ResultSet rs = null;

int var3 = Integer.parseInt(request.getParameter("num1"));
int var4 = Integer.parseInt(request.getParameter("num2"));


String url= "***";
String id= "***";
String pass = "***";

try{


Class.forName("com.mysql.jdbc.Driver");
con = java.sql.DriverManager.getConnection(url, id, pass);

}catch(ClassNotFoundException cnfex){
cnfex.printStackTrace();

}
String sql = "select name from demo where id="+var3;
String sql1 = "update demo set name='XYZ' where id="+var4;

try{    //try start

    s = con.createStatement();
        rs = s.executeQuery(sql);
%>
<%
String retnValue = null;
if( rs.next() ){ //while start
    retnValue = rs.getString(1);
}
%>
<p>String value is <%=retnValue%></p>
<% if ( retnValue != null) { //ifstart
%>
<%
try{ //try1start

    int count = s.executeUpdate(sql1); 
%>
    <p>The update is successful.<%=count%> record updated successfully.</p>
 <%

} //try1end
catch(Exception e){e.printStackTrace();}
finally{ //finallystart
if(rs!=null) rs.close();
if(s!=null) s.close();
if(con!=null) con.close();
}//finallyend
%>
<% } %>
<%
//} //whileend
%>
<%
} //tryend
catch(Exception e){e.printStackTrace();}
finally { //finallystart
if(rs!=null) rs.close();
if(s!=null) s.close();
if(con!=null) con.close();
} //finallyend
%>

</body>