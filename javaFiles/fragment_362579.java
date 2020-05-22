httpclient.addResponseInterceptor(new HttpResponseInterceptor() {

public void process(
        final HttpResponse response,
        final HttpContext context) throws HttpException, IOException {
    HttpEntity entity = response.getEntity();
    if (entity != null) {
        InputStream instream = entity.getContent();
        if (instream instanceof ChunkedInputStream) {
            Header[] footers = ((ChunkedInputStream) instream).getFooters();
        }
    }
}