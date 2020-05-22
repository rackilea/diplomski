<%@ page import="java.net.*,java.io.*" %>
<%
URL url = new URL("http://localhost:8080/a.jsp");
HttpURLConnection conn = (HttpURLConnection)url.openConnection();
conn.setRequestMethod("GET");
if(HttpURLConnection.HTTP_OK == conn.getResponseCode()){
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()), 8192);
    StringBuilder sb = new StringBuilder();
    String line = "";
    while ((line = in.readLine()) != null) {
        sb.append(line);
    }
    in.close(); 
    out.print("import of a.jsp is ----" + sb.toString());
}else out.print("Response code is " + conn.getResponseCode());
%>