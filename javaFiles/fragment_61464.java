private static long toLong(byte[] value) {
    ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
    final byte val = (byte) (value[0] < 0 ? 0xFF : 0);

    for(int i = value.length; i < Long.BYTES; i++)
        buffer.put(val);

    buffer.put(value);
    return buffer.getLong(0);
}