static BigInteger a = new BigInteger("2014");
static BigInteger b = new BigInteger("69");   

public static BigInteger computeNthTerm(int n) {
   BigInteger prev1 = new BigInteger("1");
   BigInteger prev2 = new BigInteger("1");
   BigInteger nth = new BigInteger("1");
   for(int k=2; k<n; k++) {
      nth = prev2.multiply(a).add( prev1.multiply(b) );
      prev1 = prev2;
      prev2 = nth;
   }
   return nth;
}