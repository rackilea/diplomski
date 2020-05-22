try { 

String myXML = "<? xml version=1.0> <Request> <Elemtnt> <data id=\"1\">E1203</data> <data id=\"2\">E1204</data> </Element> </Request>";

HttpClient httpClient = new DefaultHttpClient(); 
HttpContext localContext = new BasicHttpContext(); 
HttpPost httpPost = new HttpPost("https://www.google.com/calendar/feeds/default/owncalendars/full"); 

List<NameValuePair> dataToPost = new ArrayList<NameValuePair>(); 

dataToPost.add(new BasicNameValuePair("yourxml", myXML)); 

httpPost.setEntity(new UrlEncodedFormEntity(dataToPost)); 

HttpResponse response = httpClient.execute(httpPost, localContext); 

} catch (Exception e) { 
e.printStackTrace(); 
}