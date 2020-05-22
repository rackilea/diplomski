List<NameValuePair> formparams = new ArrayList<NameValuePair>();
    formparams.add(new BasicNameValuePair("your parameter name","your parameter value"));
    formparams.add(new BasicNameValuePair("another parameter name","another paramete value"));
    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
    HttpPost httppost = new HttpPost("http://localhost/");
    httppost.setEntity(entity);
    HttpClient httpclient = new DefaultHttpClient();
    HttpResponse response = httpclient.execute(httppost);