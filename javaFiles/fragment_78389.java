public void post(String url, File sendFile) throws UnsupportedEncodingException, IOException {
    long start = System.nanoTime();    
    HttpParams params = new BasicHttpParams();
    params.setParameter(HttpProtocolParams.USE_EXPECT_CONTINUE, true);
    HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
    HttpClient client = new DefaultHttpClient(params);
    HttpPost post = new HttpPost(url);
   MultipartEntity reqEntity = new MultipartEntity(){
    ProgressListener listener;           
                public void writeTo(final OutputStream outstream) throws IOException {
                    super.writeTo(new UploadStream(outstream,listener));                                 
                }
            };
    reqEntity.addPart("userfile", new FileBody(sendFile));
    post.setEntity(reqEntity);
    HttpResponse response = client.execute(post);
    if (response != null) {
    HttpEntity resEntity = response.getEntity();
    System.out.println(response.getStatusLine());
    if (resEntity != null) {
    System.out.println(EntityUtils.toString(resEntity));
    }
    if (resEntity != null) {
      resEntity.consumeContent();
    }
    }  
}