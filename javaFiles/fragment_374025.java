BigInteger root(int n, BigInteger x) {
    BigInteger y = BigInteger.ZERO;
    for (int m = (x.bitLength() - 1)/n; m >= 0; --m) {
        BigInteger z = y.setBit(m);
        int cmp = z.pow(n).compareTo(x);
        if (cmp == 0) return z; // found exact root
        if (cmp < 0) y = z;     // keep bit set
    }
    return y; // return floor of exact root
}