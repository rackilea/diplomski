InputStream is = entity.getContent(); // 'is' now accessible in both try-catch
HttpEntity entity = response.getEntity(); // 'entity' is now accessible in both try-catch
try{
    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost("http://example.com/getAllPeopleBornAfter.php");
    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    HttpResponse response = httpclient.execute(httppost);
    ...
    ...
}