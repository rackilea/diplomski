class ConditionalCachingExec implements ClientExecChain {

    private final ClientExecChain mainExec;
    private final ClientExecChain cachingExec;

    public ConditionalCachingExec(final ClientExecChain mainExec, final ClientExecChain cachingExec) {
        this.mainExec = mainExec;
        this.cachingExec = cachingExec;
    }

    @Override
    public CloseableHttpResponse execute(
            final HttpRoute route,
            final HttpRequestWrapper request,
            final HttpClientContext clientContext,
            final HttpExecutionAware execAware) throws IOException, HttpException {
        URI uri = request.getURI();
        if ("/stuff".equals(uri.getPath())) {
            return mainExec.execute(route, request, clientContext, execAware);
        } else {
            return cachingExec.execute(route, request, clientContext, execAware);
        }
    }

};

class MyCachingHttpClientBuilder extends CachingHttpClientBuilder {

    @Override
    protected ClientExecChain decorateMainExec(final ClientExecChain mainExec) {
        ClientExecChain cachingExec = super.decorateMainExec(mainExec);
        return new ConditionalCachingExec(mainExec, cachingExec);
    }

};


CloseableHttpClient httpClient = new MyCachingHttpClientBuilder().build();