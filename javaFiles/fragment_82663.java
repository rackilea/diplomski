<%@ page import="java.util.Properties" %>
<%@ page import="java.util.Set" %>

<%
Properties p = System.getProperties();

Set<String> keys = p.stringPropertyNames();
for (String key : keys)
  out.println(key + " : " + p.getProperty(key));

%>