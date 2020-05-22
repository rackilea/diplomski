public static int countSets(int setSize, long bits) {
    Long mask = (1L << setSize) - 1;
    int count = 0;
    for (long b = bits; b != 0; b >>>= setSize)
        if ((b & mask) != 0)
            count++;
    return count;
}