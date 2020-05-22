static native byte[] bytes();

static BigInteger bigInteger() {
    final byte[] bytes = bytes();
    return bytes == null ? null : new BigInteger(1, bytes);
}