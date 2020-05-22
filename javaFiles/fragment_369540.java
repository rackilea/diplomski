ClientHttpRequestInterceptor interceptor = new ClientHttpRequestInterceptor() {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        request.getHeaders().add("Content-Encoding", "gzip");
        byte[] gzipped = getGzip(body);
        return execution.execute(request, gzipped);
    } 
 }