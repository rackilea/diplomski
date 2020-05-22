public class HttpGetConnection implements AutoCloseable {
    public HttpGetConnection(String url) throws IOException {
        client = new DefaultHttpClient();
        get = new HttpGet(url);
        response = client.execute(get);
        entity = response.getEntity();
    }

    public InputStream getContent() throws IOException {
        content = entity.getContent();
        return content;
    }

    @Override
    public void close() throws Exception {
        get.abort();
        try {
            content.close();
        }
        catch (IOException e) {
        }
    }

    private HttpClient client;
    private HttpGet get;
    private HttpResponse response;
    private HttpEntity entity;
    private InputStream content;
}