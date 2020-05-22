private static boolean isCoprime(long u, long v) {
    // If both numbers are even, then they are not coprime.
    if (((u | v) & 1) == 0) return false;

    // Now at least one number is odd. Eliminate all the factors of 2 from u.
    while ((u & 1) == 0) u >>= 1;

    // One is coprime with everything else by definition.
    if (u == 1) return true;

    do {
        // Eliminate all the factors of 2 from v, because we know that u and v do not have any 2's in common.
        while ((v & 1) == 0) v >>= 1;

        // One is coprime with everything else by definition.
        if (v == 1) return true;

        // Swap if necessary to ensure that v >= u.
        if (u > v) {
            long t = v;
            v = u;
            u = t;
        }

        // We know that GCD(u, v) = GCD(u, v - u).
        v -= u;
    } while (v != 0);

    // When we reach here, we have v = 0 and GCD(u, v) = current value of u, which is greater than 1.
    return false;
}