public static byte[] toByteArray(int value) {
    ByteBuffer bb = ByteBuffer.allocate(4).order(ByteOrder.nativeOrder());
    return bb.putInt(value).array();
}

public static int toInteger(byte[] bytes) {
    ByteBuffer bb = ByteBuffer.wrap(bytes).order(ByteOrder.nativeOrder());
    return bb.getInt();
}