public static boolean IsPrime(BigInteger textOne) {
    // check if number is a multiple of 2
    if (textOne.mod(new BigInteger("2")).compareTo(BigInteger.ZERO) == 0) {
      return false;
    }// if not, then just check the odds
    for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(textOne) <= 0; i =
        i.add(new BigInteger("2"))) {
      if (textOne.mod(i).compareTo(BigInteger.ZERO) == 0) {

       return false;
      }
    }
    return true;
}   
public static boolean IsPrime2(BigInteger textTwo) {
    // check if number is a multiple of 2
    if (textTwo.mod(new BigInteger("2")).compareTo(BigInteger.ZERO) == 0) {
      return false;
    }// if not, then just check the odds
    for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(textTwo) <= 0; i =
        i.add(new BigInteger("2"))) {
      if (textTwo.mod(i).compareTo(BigInteger.ZERO) == 0) {

       return false;
      }
    }
    return true;
}