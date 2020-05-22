class Wrapper {
    final byte[] buffer;

    public Wrapper(final ByteBuffer buffer) {
        super();
        this.buffer = buffer != null ? buffer.array() : new byte[0];
    }
}