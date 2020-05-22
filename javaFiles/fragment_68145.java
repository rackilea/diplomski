ZeroCopyPost zeroCopyPost = new ZeroCopyPost(
        URI.create("/"),
        new File("stuff"),
        ContentType.DEFAULT_BINARY) {

    @Override
    protected HttpEntityEnclosingRequest createRequest(
            final URI requestURI, final HttpEntity entity) {
        HttpEntityEnclosingRequest request = super.createRequest(requestURI, entity);
        request.setHeader("my-header", "whatever");
        return request;
    }
};