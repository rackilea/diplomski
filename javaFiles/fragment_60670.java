String pageUrl ="http://......";
String username = "yourUsername";
String password = "yourPassword";

HttpParams httpParams = new BasicHttpParams();
int timeoutConnection = 10000;
HttpConnectionParams.setConnectionTimeout(httpParams, timeoutConnection);
int timeoutSocket = 10000;
HttpConnectionParams.setSoTimeout(httpParams, timeoutSocket);

HttpClient httpClient = new DefaultHttpClient(httpParams);

HttpGet httpGet = new HttpGet(pageUrl);
String credential = Base64.encodeToString( (username+":"+password).getBytes("UTF-8"), Base64.DEFAULT);
httpGet.setHeader("Authorization", "Basic " + credential.substring(0, credential.length()-1));
httpGet.setHeader("Accept", "application/json");
httpGet.setHeader("Connection", "close");
      
HttpResponse httpResponse = httpClient.execute(httpGet);
StatusLine statusLine = httpResponse.getStatusLine();    
if(statusLine.getStatusCode() == HttpStatus.SC_OK)
{
  ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
  httpResponse.getEntity().writeTo(outputStream);
  String responseString = outputStream.toString();
  System.out.println(responseString);
  ......  //processding operations    
}