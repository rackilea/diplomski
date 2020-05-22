<% page import="foo" %>
<% page import="bar" %>

<%
   for (int i = 0; i < 1000; i++) {
       out.println("I should not use scriptlets.");
   }
%>

(newline here)