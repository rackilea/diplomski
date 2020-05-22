HttpClient httpclient = new DefaultHttpClient();
HttpHead httphead = new HttpHead("http://foo/bar");
HttpResponse response = httpclient.execute(httphead);
BasicHeader contenttypeheader = response.getFirstHeader("Content-Type");

System.out.println(contenttypeheader);