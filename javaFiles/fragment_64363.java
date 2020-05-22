HttpParams params = new BasicHttpParams();
//params.setParameter("data", auth);
HttpClient httpclient = new DefaultHttpClient(params);

HttpPost httpPost = new HttpPost("http://project.chippy.ch/upload.php");

List<NameValuePair> postParams = new ArrayList<NameValuePair>();
postParams.add(new BasicNameValuePair("data", auth.toString()));

UrlEncodedFormEntity entity = new UrlEncodedFormEntity(postParams);
entity.setContentEncoding(HTTP.UTF_8);
httpPost.setEntity(entity);