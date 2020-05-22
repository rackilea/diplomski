HttpClient Client = new DefaultHttpClient();

List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
nameValuePairs.add(new BasicNameValuePair("id", sID));
nameValuePairs.add(new BasicNameValuePair("etc", sETC));

try {           

    String SetServerString = "";

    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost("http://your-url.com/script.php");
    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    ResponseHandler<String> responseHandler = new BasicResponseHandler();

    SetServerString = httpclient.execute(httppost, responseHandler);                

}  catch(Exception ex) {
    // failed
}