long uAdd(long a, long b) {
    long sum = a + b;
    if (uLess(sum, a)) {
        throw new ArithmeticException("Overflow");
    } else {
        return sum;
    }
}

/** @return whether a < b, treating both a and b as unsigned longs */
boolean uLess(long a, long b) {
    long signBit = 1L << -1;
    return (signBit ^ a) < (signBit ^ b);
}