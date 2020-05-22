private int zeroPrefixLength(final byte[] bytes) {
    for (int i = 0; i < bytes.length; i++) {
        if (bytes[i] != 0) {
            return i;
        }
    }
    return bytes.length;
}