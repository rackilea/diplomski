static final long safeMultiply(long left, long right)
                 throws ArithmeticException {
  if (right > 0
         ? left > Long.MAX_VALUE/right || left < Long.MIN_VALUE/right 
         : (right < -1
             ? left > Long.MIN_VALUE/right  || left < Long.MAX_VALUE/right
             : right == -1 && left == Long.MIN_VALUE) ) {
      throw new ArithmeticException("Long overflow");
  }
  return left * right;
}