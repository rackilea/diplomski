private static long getSeed(double val) {
    long lval = (long) (val * (1L << 53));
    // let t = first seed (generating the high bits of this double)
    // let u = second seed (generating the low bits of this double)
    long a = lval >> 27; // a is the high 26 bits of t
    long b = lval & ((1 << 27) - 1); // b is the high 27 bits of u

    // ((a << 22) + c) * 0x5deece66d + 0xb = (b << 21) + d (mod 2**48)
    // after rearranging this gives
    // (b << 21) - 11 - (a << 22) * 0x5deece66d = c * 0x5deece66d - d (mod 2**48)
    // and because modular arithmetic
    // (b << 21) - 11 - (a << 22) * 0x5deece66d + (k << 48) = c * 0x5deece66d - d
    long lhs = ((b << 21) - 0xb - (a << 22) * 0x5deece66dL) & 0xffffffffffffL;

    // c * 0x5deece66d is 56 bits max, which gives a max k of 375
    // also check k = 65535 because the rhs can be negative
    for (long k = 65535; k != 376; k = k == 65535 ? 0 : k + 1) {
        // calculate the value of d
        long rem = (0x5deece66dL - (lhs + (k << 48))) % 0x5deece66dL;
        long d = (rem + 0x5deece66dL) % 0x5deece66dL; // force positive
        if (d < (1 << 21)) {
            // rearrange the formula to get c
            long c = lhs + d;
            c *= 0xdfe05bcb1365L; // = 0x5deece66d**-1 (mod 2**48)
            c &= 0xffffffffffffL;
            if (c < (1 << 22)) {
                long seed = (a << 22) + c;
                seed = ((seed - 0xb) * 0xdfe05bcb1365L) & 0xffffffffffffL; // run the LCG forwards one step
                return seed;
            }
        }
    }

    return Long.MAX_VALUE; // no seed
}