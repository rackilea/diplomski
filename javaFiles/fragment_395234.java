<%@ page import="org.springframework.web.context.support.ServletContextResourceLoader, org.springframework.core.io.Resource" %>
<%@ page import="org.apache.commons.io.IOUtils" %>

<%
    String path = "/resources/fileName.html";
    ServletContextResourceLoader loader = new ServletContextResourceLoader(getServletConfig().getServletContext());
    Resource resource = loader.getResource(path);
    IOUtils.copy(contentResource.getInputStream(), pageContext.getOut());
 %>