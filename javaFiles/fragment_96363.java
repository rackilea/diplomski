<%

String user = "", wordDisplay = "";

user = request.getParameter("user");

if(user != null && !user.equals(""))    
wordDisplay = user;     
else    
wordDisplay = "World";

%>

<HTML>
<BODY>
Hello <b><%= wordDisplay %></b>!
</Body>
</HTML>