for (int i = 1; i < 100; i++) {
    BigInteger mod = BigInteger.valueOf(48).pow(i).mod(BigInteger.valueOf(2401));
    double x = Math.pow(48, i) % 2401;
    if (mod.intValue() != x) {
        System.out.println(i + ": " + mod + " vs " + x);
        break;
    }
}