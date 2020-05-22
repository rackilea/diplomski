<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils,
org.springframework.context.ApplicationContext,
my.package.MyApplication" %>
<%
ApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
MyApplication app = (MyApplication) appCtx.getBean("web.handler");
Object result = app.myMethod();
System.out.println("Result: " + result);
%>