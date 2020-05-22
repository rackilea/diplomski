HttpGet httpRequest = new HttpGet();
httpRequest.setURI(new URI("http://www.somewebsite.com/picture15.jpg"));
HttpClient httpclient = new DefaultHttpClient();
HttpResponse response = (HttpResponse) httpclient.execute(httpRequest);
HttpEntity entity = response.getEntity();
BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(entity);
Bitmap bm = BitmapFactory.decodeStream(bufHttpEntity.getContent());
httpRequest.abort();