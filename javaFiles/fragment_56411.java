<% if(session.getAttribute("email") != null)
{
 out.println(session.getAttribute("email"));
}else{ %>
<a href="/login-admin" class="btn btn-default"style="color:#4b4f54; font-weight:bold; border:1px solid #4b4f54;">Log In</a> 
<%} %>