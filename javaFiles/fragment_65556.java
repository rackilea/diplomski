public static boolean isBigPrime(BigInteger n) {
    if (n.compareTo(new BigInteger("2")) < 0) return false;
    else if (n.compareTo(new BigInteger("2")) == 0) return true;
    for (BigInteger i = new BigInteger("2"); i.compareTo(n.divide(new BigInteger("2"))) < 0; i = i.add(BigInteger.ONE))
        if (n.mod(i).equals(BigInteger.ZERO))
            return false;
    return true;
}