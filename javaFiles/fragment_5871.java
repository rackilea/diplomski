HttpClient httpclient = new DefaultHttpClient();
HttpPost httppost = new HttpPost(REQUEST_URL);
List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//put here in nameValuePairs request parameters

UrlEncodedFormEntity form;
form = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
form.setContentEncoding(HTTP.UTF_8);
httppost.setEntity(form);

HttpResponse response = httpclient.execute(httppost);