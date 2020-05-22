class WriteOp implements CompletionHandler<Integer, AsynchronousFileChannel> {
  private final ByteBuffer buf;
  private long position;

  WriteOp(ByteBuffer buf, long position) {
    this.buf = buf;
    this.position = position;
  }

  public void completed(Integer result, AsynchronousFileChannel channel) {
    if ( buf.hasRemaining() ) { // incomplete write
      position += result;
      channel.write( buf, position, channel, this );
    }
  }

  public void failed(Throwable ex, AsynchronousFileChannel channel) {
    // ?
  }
}

class AsyncAppender {
  private final AsynchronousFileChannel channel;
  /** Where new append operations are told to start writing. */
  private final AtomicLong projectedSize;

  AsyncAppender(AsynchronousFileChannel channel) throws IOException {
    this.channel = channel;
    this.projectedSize = new AtomicLong(channel.size());
  }

  public void append(ByteBuffer buf) {
    final int buflen = buf.remaining();
    long size;
    do {
      size = projectedSize.get();
    while ( !projectedSize.compareAndSet(size, size + buflen) );

    channel.write( buf, position, channel, new WriteOp(buf, size) );
  }
}