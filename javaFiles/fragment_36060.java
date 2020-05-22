private static String post(ArrayList<NameValuePair> params){        
    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httpreq = new HttpPost("www.url.com");
    httpreq.setEntity(new UrlEncodedFormEntity(params));
    HttpResponse response = httpclient.execute(httpreq);
    HttpEntity entity = response.getEntity();
    InputStream is = entity.getContent();

    BufferedReader reader = new BufferedReader(new InputStreamReader(is, NetworkConstants.HTTP_ACCEPTED_CHARSET), 8);
    StringBuilder sb = new StringBuilder();
    String line = null;
    while ((line = reader.readLine()) != null) {
        sb.append(line + "\n");
    }
    is.close();          

    return sb.toString();
}