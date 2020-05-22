final long x_hi = x >>> 32;
final long y_hi = y >>> 32;
final long x_lo = x & 0xFFFFFFFFL;
final long y_lo = y & 0xFFFFFFFFL;
long result = x_lo * y_lo;
result >>>= 32;

result += x_hi * y_lo + x_lo * y_hi;
result >>>= 32;
result += x_hi * y_hi;