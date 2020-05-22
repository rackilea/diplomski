<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@page import="java.io.*"%>
<%@page import="java.net.URL"%>
 <!-- @page contentType="text/html" pageEncoding="UTF-8" --> <!--When I use this line has conflict error -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>
    <%
        String jspPath = "C:\\Users\\Farshid\\workspace\\STPT\\WebContent\\file\\title.txt";
        BufferedReader reader = new BufferedReader(new FileReader(jspPath));
        //BufferedReader br = new InputStreamReader(new FileInputStream(txtFilePath));
        StringBuilder sb = new StringBuilder();
        String line;

        line = reader.readLine();
        out.println(sb.toString());
        System.out.println("line" +line);
    %>
 <%=line %>

</title>

</head>
<body>
<p> <%=line %></p>
</body>
</html>