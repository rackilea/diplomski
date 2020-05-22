String url = "http://www.teamliquid.net/replay/download.php?replay=1830";
HttpClient httpClient = new DefaultHttpClient();
HttpGet httpget = new HttpGet(url);
HttpContext context = new BasicHttpContext(); 
HttpResponse response = httpClient.execute(httpget, context); 
if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK)
    throw new IOException(response.getStatusLine().toString());
HttpUriRequest currentReq = (HttpUriRequest) context.getAttribute( 
    ExecutionContext.HTTP_REQUEST);
String currentUrl = URLDecoder.decode(currentReq.getURI().toString(), "UTF-8");
int i = currentUrl.lastIndexOf('/');
String fileName = null;
if (i < 0) {
    fileName = currentUrl;
} else {
    fileName = currentUrl.substring(i+1);
}
OutputStream os = new FileOutputStream("/tmp/" + fileName);
InputStream is = response.getEntity().getContent();
byte[] buf = new byte[4096];  
int read;  
while ((read = is.read(buf)) != -1) {  
   os.write(buf, 0, read);  
}  
os.close();