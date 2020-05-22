static int byteSize(long x) {
    if (x < 0) throw new IllegalArgumentException();
    int s = 1;
    while (s < 8 && x >= (1L << (s * 8))) s++;
    return s;
}