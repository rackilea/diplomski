int bitsNeededFor(int i) {
    int bits = 0;
    while (i > 0) {
        bits++;
        i /= 2;
    }
    return bits;
}