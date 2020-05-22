@Log4j2
public class AsyncChannelNettyByteBufWriter implements Closeable {
    private final AtomicReference<CompletableFuture<Long>> positionReference;
    private final AsynchronousFileChannel channel;

    public AsyncChannelNettyByteBufWriter(AsynchronousFileChannel channel) {
        this.channel = channel;
        try {
            this.positionReference = new AtomicReference<>(CompletableFuture.completedFuture(channel.size()));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public CompletableFuture<Long> write(ByteBuf byteBuffer) {
        final ByteBuf byteBuf = byteBuffer.retain();
        return positionReference.updateAndGet(x -> x.thenCompose(position -> {
            final CompletableFuture<Integer> writenBytes = new CompletableFuture<>();
            channel.write(byteBuf.nioBuffer(), position, byteBuf, new CompletionHandler<Integer, ByteBuf>() {
                @Override
                public void completed(Integer result, ByteBuf attachment) {
                    attachment.release();
                    writenBytes.complete(result);
                }

                @Override
                public void failed(Throwable exc, ByteBuf attachment) {
                    attachment.release();
                    log.error(exc);
                    writenBytes.completeExceptionally(exc);
                }
            });
            return writenBytes.thenApply(writenBytesLength -> writenBytesLength + position);
        }));
    }

    public void close() {
        positionReference.updateAndGet(x -> x.whenComplete((position, throwable) -> {
            try {
                channel.close();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }));
    }
}