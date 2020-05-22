long encode(final String key) {
    final int length = key.length();
    if (length > 8) {
        throw new IndexOutOfBoundsException(
                "key is longer than 8 characters");
    }
    long result = 0;
    for (int i = 0; i < length; i++) {
        result += ((long) ((byte) key.charAt(i))) << i * 8;
    }
    return result;
}