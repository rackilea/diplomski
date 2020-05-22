byte[] postData = urlParameters.getBytes( StandardCharsets.UTF_8 );
int postDataLength = postData.length;
String request = "<Url here>";
URL url = new URL( request );
HttpURLConnection conn= (HttpURLConnection) url.openConnection();           
conn.setDoOutput(true);
conn.setInstanceFollowRedirects(false);
conn.setRequestMethod("POST");
conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
conn.setRequestProperty("charset", "utf-8");
conn.setRequestProperty("Content-Length", Integer.toString(postDataLength ));
conn.setUseCaches(false);
try(DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
   wr.write( postData );
}