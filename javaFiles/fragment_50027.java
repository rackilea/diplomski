BigInteger a = new BigInteger(sc.next());
    BigInteger b = sc.nextBigInteger();
    BigInteger d = new BigInteger("2");
    System.out.println(d);

    BigInteger c = a.subtract(b);
    // HERE!
    c = c.divide(d);
    System.out.println(c);
    // HERE!
    a = a.subtract(c);

    System.out.println(a);
    System.out.println(c);