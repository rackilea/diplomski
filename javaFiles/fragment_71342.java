HttpResponse response;
httpClient.getParams().setParameter("Your String", "YourStringValue");
localContext = new BasicHttpContext();
HttpPost httpPost = new HttpPost(YOurURL);

Log.e("URL", URL); //just to check 

httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY,CookiePolicy.RFC_2109);

StringEntity tmp = null;

httpPost.setHeader("Accept", "application/json");

tmp = new StringEntity(inputJObject.toString(), "UTF-8");

httpPost.setEntity(tmp);

response = httpClient.execute(httpPost, localContext);


Log.i(TAG, response.getStatusLine().toString()); // Examine the response status


HttpEntity entity = response.getEntity();  // Get hold of the response entity