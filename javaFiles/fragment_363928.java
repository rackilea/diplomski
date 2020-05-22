public class MulDiv {
  public static void main(String[] args) {
    java.util.Random r = new java.util.Random();
    for (long i = 0; true; i++) {
      if (i % 1000000 == 0) {
        System.err.println(i);
      }
      long a = r.nextLong() >> (r.nextInt(8) * 8);
      long b = r.nextLong() >> (r.nextInt(8) * 8);
      long c = r.nextLong() >> (r.nextInt(8) * 8);
      if (c == 0) {
        continue;
      }
      long x = mulDiv(a, b, c);
      java.math.BigInteger aa = java.math.BigInteger.valueOf(a);
      java.math.BigInteger bb = java.math.BigInteger.valueOf(b);
      java.math.BigInteger cc = java.math.BigInteger.valueOf(c);
      java.math.BigInteger xx = aa.multiply(bb).divide(cc);
      if (java.math.BigInteger.valueOf(xx.longValue()).equals(xx) && x != xx.longValue()) {
        System.out.printf("a=%d b=%d c=%d: %d != %s\n", a, b, c, x, xx);
      }
    }
  }

  // Returns truncate(a b/c), subject to the precondition that the result is
  // defined and can be represented as a long.
  private static long mulDiv(long a, long b, long c) {
    // Decompose a.
    long a2 = a >> 42;
    long a10 = a - (a2 << 42);
    long a1 = a10 >> 21;
    long a0 = a10 - (a1 << 21);
    assert a == (((a2 << 21) + a1) << 21) + a0;
    // Decompose b.
    long b2 = b >> 42;
    long b10 = b - (b2 << 42);
    long b1 = b10 >> 21;
    long b0 = b10 - (b1 << 21);
    assert b == (((b2 << 21) + b1) << 21) + b0;
    // Compute a b.
    long ab4 = a2 * b2;
    long ab3 = a2 * b1 + a1 * b2;
    long ab2 = a2 * b0 + a1 * b1 + a0 * b2;
    long ab1 = a1 * b0 + a0 * b1;
    long ab0 = a0 * b0;
    // Compute a b/c.
    DivBy d = new DivBy(c);
    d.shift21Add(ab4);
    d.shift21Add(ab3);
    d.shift21Add(ab2);
    d.shift21Add(ab1);
    d.shift21Add(ab0);
    return d.getQuotient();
  }
}

public strictfp class DivBy {
  // Initializes n <- 0.
  public DivBy(long d) {
    di = d;
    df = (double) d;
    oneOverD = 1.0 / df;
  }

  // Updates n <- 2^21 n + i. Assumes |i| <= 3 (2^42).
  public void shift21Add(long i) {
    // Update the quotient and remainder.
    q <<= 21;
    ri = (ri << 21) + i;
    rf = rf * (double) (1 << 21) + (double) i;
    reduce();
  }

  // Returns truncate(n/d).
  public long getQuotient() {
    while (rf != (double) ri) {
      reduce();
    }
    // Round toward zero.
    if (q > 0) {
      if ((di > 0 && ri < 0) || (di < 0 && ri > 0)) {
        return q - 1;
      }
    } else if (q < 0) {
      if ((di > 0 && ri > 0) || (di < 0 && ri < 0)) {
        return q + 1;
      }
    }
    return q;
  }

  private void reduce() {
    // x is approximately r/d.
    long x = Math.round(rf * oneOverD);
    q += x;
    ri -= di * x;
    rf = repairLowOrderBits(rf - df * (double) x, ri);
  }

  private static double repairLowOrderBits(double f, long i) {
    int e = Math.getExponent(f);
    if (e < 64) {
      return (double) i;
    }
    long rawBits = Double.doubleToRawLongBits(f);
    long lowOrderBits = (rawBits >> 63) ^ (rawBits << (e - 52));
    return f + (double) (i - lowOrderBits);
  }

  private final long di;
  private final double df;
  private final double oneOverD;
  private long q = 0;
  private long ri = 0;
  private double rf = 0;
}