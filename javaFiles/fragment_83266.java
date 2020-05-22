DefaultHttpClient client = new DefaultHttpClient();
client.addRequestInterceptor(new HttpRequestInterceptor() {

    public void process(
            final HttpRequest request, 
            final HttpContext context) throws HttpException, IOException {
        request.setHeader(HTTP.TARGET_HOST, "www.whatever.com");
    }
});