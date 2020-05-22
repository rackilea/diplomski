private static long hashString64Bit(CharSequence str) {
    long result = 0xcbf29ce484222325L;
    final int len = str.length();
    for (int i = 0; i < len; i++) {
        result ^= str.charAt(i);
        result *= 0x100000001b3L;
    }
    return result;
}