// Create a new HttpClient and Post Header
HttpClient httpclient = new DefaultHttpClient();
HttpPost httppost = new HttpPost("http://www.yoursite.com/script.php");

try {
    // Add your data
    List <NameValuePair> nvps = new ArrayList <NameValuePair>();
    nvps.add(new BasicNameValuePair("test1","test1" ));
    nvps.add(new BasicNameValuePair("test2", "test2" ));
    httppost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

    // Execute HTTP Post Request
    HttpResponse response = httpclient.execute(httppost);

} catch (ClientProtocolException e) {
    // TODO Auto-generated catch block
} catch (IOException e) {
    // TODO Auto-generated catch block
}