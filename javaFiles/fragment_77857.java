String a = "0101";
    int length = a.length();
    // add a couple of more bits in front to make sure we have a positive number
    BigInteger twoToLengthPlus1 = BigInteger.ONE.shiftLeft(length + 1);
    String b = twoToLengthPlus1.add(new BigInteger(a, 2).not()).toString(2);
    // remove extra bits from the front again
    b = b.substring(b.length() - length);