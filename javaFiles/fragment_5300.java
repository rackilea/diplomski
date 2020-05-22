public static BigInteger StirlingFunction(BigInteger n, BigInteger k){
   if (BigInteger.ZERO.equals(n) && BigInteger.ZERO.equals(k)){
       return BigInteger.ONE;
   }
   //still here, not both zero
   if (BigInteger.ZERO.equals(n) || BigInteger.ZERO.equals(k)){
       return BigInteger.ZERO;
   }
   BigInteger x = StirlingFunction(n.subtract(BigInteger.ONE), k);
   BigInteger y = StirlingFunction(n.subtract(BigInteger.ONE), k.subtract(BigInteger.ONE));
   //S2(n, k) = k * S2(n - 1, k) + S2(n - 1, k - 1)
   return k.multiply(x).add(y);

    }