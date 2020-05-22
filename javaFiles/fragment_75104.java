public static void main(String[] args) throws IOException {
    final String filepath = "1.jpg";
    final String downloadUrl = "https://m0.cl/t/butterfly-3000.jpg";
    final AsyncHttpClient client = Dsl.asyncHttpClient(Dsl.config().setFollowRedirect(true)
            .setResponseBodyPartFactory(AsyncHttpClientConfig.ResponseBodyPartFactory.LAZY));
    final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2);
    final AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get(filepath), new HashSet<>(Arrays.asList(StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)), executorService);

    client.prepareGet(downloadUrl)
            .execute(new AsyncCompletionHandler<Response>() {

                private long position = 0;
                @Override
                public State onBodyPartReceived(HttpResponseBodyPart content) {
                    final ByteBuf byteBuf = ((LazyResponseBodyPart) content).getBuf().retain();
                    long currentPosition = position;
                    position+=byteBuf.readableBytes();
                    channel.write(byteBuf.nioBuffer(), currentPosition, byteBuf, new CompletionHandler<Integer, ByteBuf>() {
                        @Override
                        public void completed(Integer result, ByteBuf attachment) {
                            attachment.release();
                            if(content.isLast()){
                                try {
                                    channel.close();
                                } catch (IOException e) {
                                    throw new UncheckedIOException(e);
                                }
                            }
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuf attachment) {
                            attachment.release();
                            try {
                                channel.close();
                            } catch (IOException e) {
                                throw new UncheckedIOException(e);
                            }
                        }
                    });
                    return State.CONTINUE;
                }
                @Override
                public Response onCompleted(Response response) {
                    return response;
                }
            });
}