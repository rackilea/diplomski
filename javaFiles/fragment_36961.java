public static byte[] longToBytes(long x) {
    return ByteBuffer.allocate(Long.BYTES)
            .order(ByteOrder.LITTLE_ENDIAN)
            .putLong(x)
            .array();
}