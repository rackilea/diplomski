public Byte readByte(InputStream is) {
    return read(is, Byte.BYTES, ByteBuffer::get);
}

public Short readShort(InputStream is) {
    return read(is, Short.BYTES, ByteBuffer::getShort);
}

// And other methods...

private <T extends Number> T read(InputStream is, int length, Function<ByteBuffer, T> getter) {
    ByteBuffer bytes = ByteBuffer.allocate(length);
    bytes.order(ByteOrder.nativeOrder());
    while (0 != bytes.remaining()) {
        try {
            bytes.put((byte)is.read());
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
    bytes.rewind();
    return getter.apply(bytes);
}