public static int countSets(int setSize, int bitCount, long bits) {
    long b = bits, mask = 1;
    for (int i = 1; i < setSize; i++)
        b |= bits >>> i;
    for (int i = setSize; i < bitCount; i <<= 1)
        mask |= mask << i;
    return Long.bitCount(b & mask);
}