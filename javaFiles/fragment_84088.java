HttpResponse YourMethod(String data,String url){       

     // Create a new HttpClient and Post Header
       HttpClient httpClient= new DefaultHttpClient();
        HttpResponse response = null;
        HttpConnectionParams.setSoTimeout(httpClient.getParams(), 60000);
        HttpPost httpPost = new HttpPost(url);
        StringEntity se = new StringEntity(data,"UTF-8"); 
        se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,"text/html"));
        httpPost.setEntity(se);

        response = httpClient.execute(httpPost);

     }