static LargeInteger and(LargeInteger lhs, LargeInteger rhs) {
     long l = lhs.longValue(); // Low order bits
     long r = rhs.longValue();
     long lo = l & r;

     LargeInteger hi = LargeInteger.ZERO;
     if (lhs.bitLength() > 64 && rhs.bitLength() > 64) {
         hi = and(lhs.shiftRight(64), rhs.shiftRight(64)).shiftLeft(64);
     }
     return hi.plus(lo);
}