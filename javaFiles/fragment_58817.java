public BigInteger[] step1() {
    x2 = getRandomExponent();
    x3 = getRandomExponent();

    g2 = new BigInteger(gen + "").modPow(x2, mod);
    g3 = new BigInteger(gen + "").modPow(x3, mod);

    BigInteger[] logProof1 = createLogProof("1", g2);
    BigInteger[] logProof2 = createLogProof("2", g3);

    BigInteger c1 = logProof1[0];
    BigInteger d1 = logProof1[1];
    BigInteger c2 = logProof2[0];
    BigInteger d2 = logProof2[1];

    return new BigInteger[] { g2, g3, c1, d1, c2, d2 };
}