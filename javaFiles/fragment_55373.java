BigInteger secondLast = BigInteger.ZERO;
    BigInteger last = BigInteger.ONE;
    int count = 8182;
    for (int i = 2; i < count; ++i) {
        BigInteger n = secondLast.add(last);
        secondLast = last;
        last = n;
    }
    System.out.println(last);