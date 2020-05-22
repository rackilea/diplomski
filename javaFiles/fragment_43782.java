public static byte getBits(byte value, int from, int to) {
    if (from < 0 || from > to || to > 7)
        throw new IllegalArgumentException();
    int mask = ((1 << (to + 1)) - 1) ^ ((1 << from) - 1);
    return (byte)(value & mask);
}
public static short getBits(short value, int from, int to) {
    if (from < 0 || from > to || to > 15)
        throw new IllegalArgumentException();
    int mask = ((1 << (to + 1)) - 1) ^ ((1 << from) - 1);
    return (short)(value & mask);
}
public static int getBits(int value, int from, int to) {
    if (from < 0 || from > to || to > 31)
        throw new IllegalArgumentException();
    int mask = ((1 << (to + 1)) - 1) ^ ((1 << from) - 1);
    return value & mask;
}
public static long getBits(long value, int from, int to) {
    if (from < 0 || from > to || to > 63)
        throw new IllegalArgumentException();
    long mask = ((1L << (to + 1)) - 1) ^ ((1L << from) - 1); // <-- notice the change to long and 1L
    return value & mask;
}