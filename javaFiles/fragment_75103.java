public static void main(String[] args) throws IOException {
    final String filepath = "1.jpg";
    final String downloadUrl = "https://m0.cl/t/butterfly-3000.jpg";
    final AsyncHttpClient client = Dsl.asyncHttpClient(Dsl.config().setFollowRedirect(true)
            .setResponseBodyPartFactory(AsyncHttpClientConfig.ResponseBodyPartFactory.LAZY));
    final AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get(filepath), StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
    final AsyncChannelNettyByteBufWriter asyncChannelNettyByteBufWriter = new AsyncChannelNettyByteBufWriter(channel);

    client.prepareGet(downloadUrl)
            .execute(new AsyncCompletionHandler<Response>() {
                @Override
                public State onBodyPartReceived(HttpResponseBodyPart content) {
                    final ByteBuf byteBuf = ((LazyResponseBodyPart) content).getBuf();
                    asyncChannelNettyByteBufWriter.write(byteBuf);
                    return State.CONTINUE;
                }

                @Override
                public Response onCompleted(Response response) {
                    asyncChannelNettyByteBufWriter.close();
                    return response;
                }
            });
}