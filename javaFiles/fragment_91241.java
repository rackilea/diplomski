String emailaddress = request.getParameter("emailaddress");
String projectid = request.getParameter("projectid");
String charset = "UTF-8";
String query = String.format("emailaddress=%s&projectid=%s", 
    URLEncoder.encode(emailaddress, charset),
    URLEncoder.encode(projectid, charset));

URLConnection connection = new URL("http://abhishek:15070/abc/login.action").openConnection();
connection.setDoOutput(true);
connection.setRequestProperty("Accept-Charset", charset);
connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
try {
    connection.getOutputStream().write(query.getBytes(charset));
}
finally {
    connection.getOutputStream().close();
}
InputStream response = connection.getInputStream();
// ...