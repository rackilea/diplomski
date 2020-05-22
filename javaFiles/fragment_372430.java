<%@page import="java.io.File"%>
<%@page import="org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader"%>
<%@page import="org.apache.velocity.runtime.RuntimeConstants"%>
<%@page import="java.io.StringWriter"%>
<%@page import="org.apache.velocity.VelocityContext"%>
<%@page import="org.apache.velocity.Template"%>
<%@page import="org.apache.velocity.app.VelocityEngine"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
     String s = request.getParameter("test");
    VelocityEngine velocityEngine = new VelocityEngine();
    velocityEngine.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, "/");

    velocityEngine.init();
    Template t = velocityEngine.getTemplate("/template.vm");
    VelocityContext context = new VelocityContext();
    context.put("example",
            s);
    StringWriter w = new StringWriter();
    t.merge(context, w); 


%>
<p><%out.println(w.getBuffer().toString());  %> </p>
 </body>
</html>