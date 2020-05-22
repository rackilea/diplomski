public void generateKeys(int bitSize) {
    Random rnd = new Random();
    //1
    BigInteger p = BigInteger.probablePrime(bitSize, rnd);
    BigInteger q = BigInteger.probablePrime(bitSize, rnd);

    //2
    n = p.multiply(q);

    //3
    BigInteger euler = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

    //4
    BigInteger x = BigInteger.valueOf(65537);

    do {
        if (euler.gcd(x).equals(BigInteger.ONE)) {
            e = x;
            //5
            d = gcdExtended(e, euler);
            if (d.signum() == 1) {
                break;
            }
        }
        x = x.add(BigInteger.ONE);
    } while (true);
}