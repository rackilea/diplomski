String url = "https://www.google-analytics.com/analytics.js";        
HttpURLConnection connection = (HttpURLConnection) (new URL(url)).openConnection();
connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
connection.setRequestProperty("Range", "bytes=0-1");
connection.connect();

int contentLength = connection.getContentLength();
String contentRange = connection.getHeaderField("Content-Range");
if (contentRange != null) {
    contentLength = Integer.parseInt(contentRange.split("/")[1]);
}
System.out.println("Content-Length: " + contentLength);