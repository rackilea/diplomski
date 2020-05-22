<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
<%@ page import="java.sql.*,stack.filter.JDBCConnector" %>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Radio Select</title>
</head>
<body>
<%
Connection con = null;
String firstname = null;
String lastname = null;
String email = null;
String flag = null;
try {
    con = JDBCConnector.connect_database();
    Statement stmt = con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from assignment where id=1");

    while(rs.next()){
        firstname=rs.getString(2);
        lastname=rs.getString(3);
        email=rs.getString(4);
        flag=rs.getString(5);
    }
    System.out.println(""+firstname+" "+lastname+" "+email+" "+flag);
} catch (Exception e) {
    e.printStackTrace();
} finally {
    con.close();
}
%>
<table>
    <tr>
        <td>
              Name:  <% out.println(firstname); %> <% out.println(lastname);          %>
        </td>
        <td> 
         <%
            if(flag.equals("A")){
                %> Active: <input type="radio" name="<%=email%>" id="r1" value="A" onclick="updateStatus()" checked="checked"/> 
                 In active: <input type="radio" name="<%=email%>" id="r2" value="I" onclick="updateStatus()"/>
                 <%
            }else if(flag.equals("I")){
                %> Active: <input type="radio" name="<%=email%>" id="r1" value="A" onclick="updateStatus()"/> 
                 In active: <input type="radio" name="<%=email%>" id="r2" value="I" onclick="updateStatus()" checked="checked"/>
                 <%
            }
         %>
        </td>
    </tr>
</table>
<script type="text/javascript">
        function updateStatus(){
            if (document.getElementById('r1').checked) {
                location.href='changeToActive.jsp?email='+'${email}'+'&status=A';
            }else if (document.getElementById('r2').checked) {
                location.href='changeToActive.jsp?email='+'${email}'+'&status=I';
            }       
        }
</script>
</body>
</html>