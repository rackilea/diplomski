BigInteger n = BigInteger.valueOf(10);
    BigInteger ret = BigInteger.ONE;
    for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
        ret = ret.multiply(i);
    }
    System.out.println(ret);