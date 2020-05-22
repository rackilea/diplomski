private static final byte SIGN_BIT = (byte)0x40;
private static final byte STOP_BIT = (byte)0x80;
private static final byte PAYLOAD_MASK = 0x7F;

public static int decodeInt(final ByteBuffer buffer) {
    int value = 0;
    int currentByte = buffer.get();

    if ((currentByte & SIGN_BIT) > 0)
        value = -1;

    value = (value << 7) | (currentByte & PAYLOAD_MASK);
    if ((currentByte & STOP_BIT) != 0)
        return value;

    currentByte = buffer.get();
    value = (value << 7) | (currentByte & PAYLOAD_MASK);
    if ((currentByte & STOP_BIT) != 0)
        return value;

    currentByte = buffer.get();
    value = (value << 7) | (currentByte & PAYLOAD_MASK);
    if ((currentByte & STOP_BIT) != 0)
        return value;

    currentByte = buffer.get();
    value = (value << 7) | (currentByte & PAYLOAD_MASK);
    if ((currentByte & STOP_BIT) != 0)
        return value;

    currentByte = buffer.get();
    value = (value << 7) | (currentByte & PAYLOAD_MASK);
    return value;
}