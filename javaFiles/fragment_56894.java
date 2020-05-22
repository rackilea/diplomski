public static byte[] possitiveIntegerToOctetString(
        final long value, final int octets) {
    if (value < 0) {
        throw new IllegalArgumentException("Cannot encode negative values");
    }

    if (octets < 1) {
        throw new IllegalArgumentException("Cannot encode a number in negative or zero octets");
    }

    final int longSizeBytes = Long.SIZE / Byte.SIZE;
    final int byteBufferSize = Math.max(octets, longSizeBytes);
    final ByteBuffer buf = ByteBuffer.allocate(byteBufferSize);
    for (int i = 0; i < byteBufferSize - longSizeBytes; i++) {
        buf.put((byte) 0x00);
    }
    buf.mark();
    buf.putLong(value);

    // more bytes than long encoding
    if (octets >= longSizeBytes) {
        return buf.array();
    }

    // less bytes than long encoding (reset to mark first)
    buf.reset();
    for (int i = 0; i < longSizeBytes - octets; i++) {
        if (buf.get() != 0x00) {
            throw new IllegalArgumentException("Value does not fit in " + octets +  " octet(s)");
        }
    }

    final byte[] result = new byte[octets];
    buf.get(result);
    return result;
}