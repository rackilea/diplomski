for ( int i = 0; i < 10; i++ ) {
  BigInteger p = BigInteger.ONE.shiftLeft(i+2).subtract(BigInteger.ONE).shiftLeft(i+1);
  System.out.println(p.toString(10)+" = "+p.toString(2));
  //long q = ((1 << (i+2)) - 1) << (i+1);
  //BigInteger bq = BigInteger.valueOf(q);
  //System.out.println("    "+bq.toString(10)+" = "+bq.toString(2));
}