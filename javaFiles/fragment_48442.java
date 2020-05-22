class PureHttpClient extends CloseableHttpClient {
    private final CloseableHttpClient client;
    private final String service;

    PureHttpClient(CloseableHttpClient client, String service) {
        this.client = client;
        this.service = service;
    }

    @Override
    public void close() throws IOException {
        if (client != null)
            client.close();
    }

    private HttpUriRequest appendService(HttpRequest request, String service) throws ClientProtocolException {
        HttpRequestWrapper wrappedRequest = HttpRequestWrapper.wrap(request);

        try {
            URI uri = wrappedRequest.getURI();
            URI newUri = new URIBuilder(uri)
                    .setPath(service + uri.getPath())
                    .build();
            wrappedRequest.setURI(newUri);
        } catch (URISyntaxException e) {
            throw new ClientProtocolException(e.getMessage(), e);
        }
        return wrappedRequest;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public HttpParams getParams() {
        return client.getParams();
    }

    @Override
    public ClientConnectionManager getConnectionManager() {
        return client.getConnectionManager();
    }

    @Override
    public CloseableHttpResponse execute(HttpUriRequest request) throws IOException, ClientProtocolException {
        return client.execute(appendService(request, service));
    }

    @Override
    public CloseableHttpResponse execute(HttpUriRequest request, HttpContext context) throws IOException, ClientProtocolException {
        return client.execute(appendService(request, service), context);
    }

    @Override
    public CloseableHttpResponse execute(HttpHost target, HttpRequest request) throws IOException, ClientProtocolException {
        return client.execute(target, appendService(request, service));
    }

    @Override
    public CloseableHttpResponse execute(HttpHost target, HttpRequest request, HttpContext context) throws IOException, ClientProtocolException {
        return client.execute(target, appendService(request, service), context);
    }

    @Override
    public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return client.execute(appendService(request, service), responseHandler);
    }

    @Override
    public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        return client.execute(appendService(request, service), responseHandler);
    }

    @Override
    public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return client.execute(target, appendService(request, service), responseHandler);
    }

    @Override
    public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException, ClientProtocolException {
        return client.execute(target, appendService(request, service), responseHandler);
    }

    @Override
    protected CloseableHttpResponse doExecute(HttpHost target, HttpRequest request, HttpContext context) throws IOException, ClientProtocolException {
        return this.execute(target, request, context);
    }
}