private static void method2(byte[] bytes) {
    byte prevByte = bytes[bytes.length-1];
    for (int i = bytes.length-1; i > 0; i--) {
        byte tmp = bytes[i];
        bytes[i] = (byte) (((bytes[i] & 0xff) >> 1) | ((prevByte & 0xff) << 7));
        prevByte = tmp;
    }
    bytes[0] = (byte) (((bytes[0] & 0xff) >> 1) | ((bytes[bytes.length-1] & 0xff) << 7));
}