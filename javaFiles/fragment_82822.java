HttpURLConnection httpConn = (HttpURLConnection)connection;
InputStream is;
if (httpConn.getResponseCode() >= 400) {
    is = httpConn.getErrorStream();
} else {
    is = httpConn.getInputStream();
}

BufferedReader reader = new BufferedReader(new  InputStreamReader(is));   
while ((line = reader.readLine()) != null) {
     response += line;
}
reader.close();