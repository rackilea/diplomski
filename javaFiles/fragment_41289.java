<%
    String location = System.getProperty("catalina.base") + 
    java.io.File.separator + "logs" + java.io.File.separator + 
    "localhost_access_log." + new java.sql.Date(System.currentTimeMillis()) +
    ".txt";
%>