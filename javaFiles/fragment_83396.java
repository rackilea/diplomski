public String fromUTF16LE(int... bytes) {
    byte[] b = new byte[bytes.length];
    for (int i = 0; i < b.length; ++) {
        b[i] = (byte) bytes[i];
    }
    return new String(b, StandardCharsets.UTF_16LE);
}