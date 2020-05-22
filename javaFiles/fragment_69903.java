CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
HttpAsyncResponseConsumer responseConsumer = new BasicAsyncResponseConsumer() {

    @Override
    protected void onResponseReceived(final HttpResponse response) throws IOException {
        super.onResponseReceived(response);
    }

    @Override
    protected void onEntityEnclosed(final HttpEntity entity, final ContentType contentType) throws IOException {
        super.onEntityEnclosed(entity, contentType);
    }

    @Override
    protected void onContentReceived(final ContentDecoder decoder, final IOControl ioctrl) throws IOException {
        super.onContentReceived(decoder, ioctrl);
    }

    @Override
    protected HttpResponse buildResult(HttpContext context) {
        return super.buildResult(context);
    }

    @Override
    protected void releaseResources() {
        super.releaseResources();
    }
};
client.execute(HttpAsyncMethods.createGet("http://target/"), consumer, null);