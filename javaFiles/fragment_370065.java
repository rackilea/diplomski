public static final void nioCopy(ReadableByteChannel input, WritableByteChannel output) throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(DEFAULT_BUFFER_SIZE);
    while (input.read(buffer) != -1) {
        //Flip buffer
        buffer.flip();
        //Write to destination
        output.write(buffer);
        //Compact
        buffer.compact();
    }

    //In case we have remainder
    buffer.flip();
    while (buffer.hasRemaining()) {
        //Write to output
        output.write(buffer);
    }
}