HttpClient httpclient = new DefaultHttpClient();
httpclient.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);
HttpGet request = new HttpGet("http://www.echo.msk.ru/interview/rss-audio.xml");  
HttpResponse response = httpclient.execute(request);
HttpEntity resEntity = response.getEntity();
String  _response=EntityUtils.toString(resEntity); 
 Log.i(".......",_response);