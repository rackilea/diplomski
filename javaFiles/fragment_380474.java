<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>

<%
  WebApplicationContext context = WebApplicationContextUtils
        .getWebApplicationContext(application);
  QuizService service = context.getBean(QuizeService.class);
%>