<%
//Get version of application
java.util.Properties prop = new java.util.Properties();
prop.load(getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF"));
String applVersion = prop.getProperty("Implementation-Version");  
%>
<h2 class="x-panel-header"><%=applVersion%></h2>