long lowestMersenneNotLessThan(long lowerBound) {
    long x = lowerBound;
    x |= x >> 1;
    x |= x >> 2;
    x |= x >> 4;
    x |= x >> 8;
    x |= x >> 16;
    x |= x >> 32;
    return x;
}