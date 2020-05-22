public class ChunkedList implements ChunkedInput<ByteBuf> {
    private static final byte[] EMPTY = new byte[0];
    private byte[] previousPart = EMPTY;
    private final int chunkSize;
    private final Iterator<Object> iterator;

    public ChunkedList(int chunkSize, List<Object> objs) {
        //chunk size in bytes
        this.chunkSize = chunkSize;
        this.iterator = objs.iterator();
    }


    public ByteBuf readChunk(ChannelHandlerContext ctx) {
        return readChunk(ctx.alloc());
    }

    public ByteBuf readChunk(ByteBufAllocator allocator) {
        if (isEndOfInput())
            return null;
        else {
            ByteBuf buf = allocator.buffer(chunkSize);
            boolean release = true;
            try {
                int bytesRead = 0;
                if (previousPart.length > 0) {
                    if (previousPart.length > chunkSize) {
                        throw new IllegalStateException();
                    }
                    bytesRead += previousPart.length;
                    buf.writeBytes(previousPart);
                }
                boolean done = false;
                while (!done) {
                    if (!iterator.hasNext()) {
                        done = true;
                        previousPart = EMPTY;
                    } else {
                        Object o = iterator.next();
                        //depending on the encoding
                        byte[] bytes = o instanceof String ? ((String) o).getBytes() : (byte[]) o;
                        bytesRead += bytes.length;
                        if (bytesRead > chunkSize) {
                            done = true;
                            previousPart = bytes;
                        } else {
                            buf.writeBytes(bytes);
                        }
                    }
                }
                release = false;
            } finally {
                if (release)
                    buf.release();
            }
            return buf;
        }
    }

    public long length() {
        return -1;
    }

    public boolean isEndOfInput() {
        return !iterator.hasNext() && previousPart.length == 0;
    }

    public long progress() {
        return 0;
    }

    public void close(){
        //close
    }
}