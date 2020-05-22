HttpPost post = new HttpPost("http://www.mysite.com/mypage.php");
List<NameValuePair> params = new ArrayList<NameValuePair>();
params.add(new BasicNameValuePair("Username", userId));
params.add(new BasicNameValuePair("Password", pass));
post.setEntity(new UrlEncodedFormEntity(params));
HttpResponse response = post.execute(post);