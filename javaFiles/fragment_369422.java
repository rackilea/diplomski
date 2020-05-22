public static BigInteger fact(long j){
  BigInteger prod = BigInteger.ONE;
  for(long i = j; i > 0; i--){
    BigInteger f = BigInteger.valueOf( i );
    prod = prod.multiply( f ); 
  }
  return prod;
}