long temp;
long p;
BigInteger opphoyd;
BigInteger mod;
for( int i = 0; i < 6; i++ ) {
   temp = number * p;
   opphoyd = BigInteger.valueOf(temp);
   mod = BigInteger.valueOf(i);
   BigInteger sum = mod.add( opphoyd.pow(i));
   sum = sum.add(opphoyd);
   System.out.println( sum );
}