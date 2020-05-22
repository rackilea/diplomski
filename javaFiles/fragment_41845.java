<%@ page import="java.security.*" %>
<%@ page import="java.net.URL" %>
<%
Class cls = org.joda.time.DateTimeZone.class;
ProtectionDomain pDomain = cls.getProtectionDomain();
CodeSource cSource = pDomain.getCodeSource();
URL loc = cSource.getLocation();
out.println(loc);
// it should print something like "c:/jars/MyJar.jar"
%>