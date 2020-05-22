<%@page import="java.net.URLEncoder" %>
<%
    String fbURL = "http://www.facebook.com/dialog/oauth?client_id=myfacebookappid&redirect_uri=" + URLEncoder.encode("http://myappengineappid.appspot.com/signin_fb.do") + "&scope=email";
%>

<a href="<%= fbURL %>"><img src="/img/facebook.png" border="0" /></a>