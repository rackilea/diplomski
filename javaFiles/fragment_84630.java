HttpPost httppost = new HttpPost(url);
List<NameValuePair> params = new ArrayList<>();
for(String s : list) 
  params.add(new BasicNameValuePair("param", s));
httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
HttpResponse response = httpclient.execute(httppost);