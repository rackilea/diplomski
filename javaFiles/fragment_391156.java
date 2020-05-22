HttpClient httpclient = new DefaultHttpClient(httpParameters);
    HttpGet httpget = new HttpGet(url);
    httpget.addHeader("If-Modified-Since", lastModified);
    HttpResponse response;
    response = httpclient.execute(httpget);
    String result = null;
    if(response.getStatusLine().getStatusCode() == 200) {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instream = entity.getContent();
            //here read contents of stream
        }
    }