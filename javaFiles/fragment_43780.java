public static byte getBits(byte b, int from, int to) {
    if (from < 0 || from > to || to > 7)
        throw new IllegalArgumentException();
    int mask = ((1 << (to + 1)) - 1) ^ ((1 << from) - 1);
    return (byte)(b & mask);
}