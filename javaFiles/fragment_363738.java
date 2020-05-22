HttpClient client = new DefaultHttpClient();
HttpPost post = new HttpPost(context.getString(R.string.loginURL));
HttpResponse response = null;
List<NameValuePair> postFields = new ArrayList<NameValuePair>(2);  

// Set the post fields
postFields.add(new BasicNameValuePair("username", settings.getString("username", "null")));
postFields.add(new BasicNameValuePair("password", settings.getString("password", "null")));
post.setEntity(new UrlEncodedFormEntity(postFields, HTTP.UTF_8));

// Execute the POST request
response = client.execute(post);