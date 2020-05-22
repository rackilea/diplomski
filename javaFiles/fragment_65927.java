public static String byteToString(byte[] bytes) {
    StringBuilder b = new StringBuilder();
    for (byte c : bytes) {
        b.append((char) (c >= 0 ? c : 256 + c));
    }
    return b.toString();
}