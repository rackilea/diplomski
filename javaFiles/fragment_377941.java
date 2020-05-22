HttpClient httpclient = new DefaultHttpClient();
HttpPost httppost = new HttpPost("http://nayyar.5gbfree.com/welcome.php");
List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(
                    postParameters);
httppost.setEntity(formEntity);
HttpResponse response = httpclient.execute(httppost);