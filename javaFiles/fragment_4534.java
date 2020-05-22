String url = "https://www.google-analytics.com/analytics.js";
HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
connection.connect();
int contentLength = connection.getContentLength();
System.out.println("Content-Length: " + contentLength);