for ( int i = 0; i < 10; i++ ) {
  long q = ((1 << (i+2)) - 1) << (i+1);
  // Printing BigIntegers in binary is easy.
  BigInteger bq = BigInteger.valueOf(q);
  System.out.println(q+" = "+bq.toString(2));
}

6 = 110
28 = 11100
120 = 1111000
496 = 111110000
2016 = 11111100000
8128 = 1111111000000
32640 = 111111110000000
130816 = 11111111100000000
523776 = 1111111111000000000
2096128 = 111111111110000000000