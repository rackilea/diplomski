HttpPost httpPost = new HttpPost(urlString);
List <NameValuePair> nvps = new ArrayList <NameValuePair>();
nvps.add(new BasicNameValuePair("code", code));
nvps.add(new BasicNameValuePair("client_id", client_id));
nvps.add(new BasicNameValuePair("client_secret", client_secret));
nvps.add(new BasicNameValuePair("redirect_uri", redirect_uri));
nvps.add(new BasicNameValuePair("grant_type", grant_type));
httpPost.setEntity(new UrlEncodedFormEntity(nvps));
HttpResponse response = httpclient.execute(httpPost);