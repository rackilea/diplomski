<%
//get UserName to verify 
String userName= (String) session.getAttribute("userName");
if(userName!=null)
{

//user is valid

}
else
{

//return here as user is invalid
response.sendRedirect("Login.jsp");

}


%>
<HTML>
<BODY>
Hello, <%= session.getAttribute("userName") %>
</BODY>
</HTML>