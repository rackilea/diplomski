HttpURLConnection c = (HttpURLConnection)new URL("http://somesite.com").openConnection();
InputStream in = null;
if (c.getResponseCode() >= 400) {
   in = c.getErrorStream();
}  
else {
   in = c.getInputStream();
}