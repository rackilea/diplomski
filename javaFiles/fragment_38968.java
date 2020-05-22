private static byte[] encodeHeader(long size) {
    if (size < 0 || size >= (1L << Integer.SIZE)) {
        throw new IllegalArgumentException("size negative or larger than 32 bits: " + size);
    }

    byte[] header = ByteBuffer
            .allocate(Long.BYTES)
            .order(ByteOrder.LITTLE_ENDIAN)
            .putInt((int) size)
            .array();
    return header;
}