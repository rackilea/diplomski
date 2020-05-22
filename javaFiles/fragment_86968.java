public int deflate(byte[] b, int off, int len, int flush) {
    if (b == null) {
        throw new NullPointerException();
    }
    if (off < 0 || len < 0 || off > b.length - len) {
        throw new ArrayIndexOutOfBoundsException();
    }
    synchronized (zsRef) {
        ensureOpen();
        if (flush == NO_FLUSH || flush == SYNC_FLUSH ||
            flush == FULL_FLUSH)
            return deflateBytes(zsRef.address(), b, off, len, flush);
        throw new IllegalArgumentException();
    }
}