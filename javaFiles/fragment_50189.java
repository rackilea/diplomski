public static long longInverse(long x) {

    if (x % 2 == 0) { throw new RuntimeException("must be odd"); }

    long power = 1L << 62;

    long a = Math.abs(x);
    long b = power;
    long sign = (x < 0) ? -1 : 1;

    long c1 = 1;
    long d1 = 0;
    long c2 = 0;
    long d2 = 1;

    // Loop invariants:
    // c1 * abs(x) + d1 * 2^62 = a
    // c2 * abs(x) + d2 * 2^62 = b 

    while (b > 0) {
        long q = a / b;
        long r = a % b;
        // r = a - qb.

        long c3 = c1 - q*c2;
        long d3 = d1 - q*d2;

        // Now c3 * abs(x) + d3 * 2^62 = r, with 0 <= r < b.

        c1 = c2;
        d1 = d2;
        c2 = c3;
        d2 = d3;
        a = b;
        b = r;
    }

    if (a != 1) { throw new RuntimeException("gcd not 1 !"); }

    // Extend from modulo 2^62 to modulo 2^64, and incorporate sign change
    // if necessary.
    for (int i = 0; i < 4; ++i) {
        long possinv = sign * (c1 + (i * power));
        if (possinv * x == 1L) { return possinv; }
    }

    throw new RuntimeException("failed");
}