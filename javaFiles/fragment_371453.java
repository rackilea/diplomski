public static byte[] download(String url) throws IOException {
    HttpClient client = new DefaultHttpClient();
    HttpGet get = new HttpGet(url);
    HttpResponse response = client.execute(get);
    StatusLine status = response.getStatusLine();
    int code = status.getStatusCode();
    if(code != 200) {
        throw new IOException(code+" response received.");
    }
    HttpEntity entity = response.getEntity();
    InputStream is = entity.getContent();
    try {
        return IOUtils.toByteArray(is);
    }finally{
        IOUtils.closeQuietly(is.close());
    }
}