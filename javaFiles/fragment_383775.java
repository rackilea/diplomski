<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>

<html>
<head>

    <%
    Class.forName("com.mysql.jdbc.Driver"); 
    java.sql.Connection con = DriverManager.getConnection
    ("jdbc:mysql://localhost:3306/cart_db","root","toor"); 
    Statement st= con.createStatement(); 
    String sql = "select * from img_table where id = 'login_bgimg'";
    ResultSet rs = st.executeQuery(sql);
    String s1 = "";
    if(rs.next())
    {   
        s1=rs.getString(2); // Image URL
    %>
     <title> Login </title>
     <link rel="stylesheet" type="text/css" href="css/Login_style.css">
 </head>
 <body background = "<%=s1%>" >
     <div class="signin">
         <form action="LoginCode.jsp" method="post">
             <h2>Sign In</h2>
             <input type="text" placeholder="Enter Username" name = "txtUserName">
             <input type="password" placeholder="Enter Password" name = "txtPWD">
             <button class = "btn">Sign In</button> <br>
             <a href="#">Forget Password?</a> | 
             <a href="#">Create an Account</a> | 
             <a href="#">Back to Home</a>
         </form>
     </div>
   <% 
   }    
   %>

 </body>
</html>