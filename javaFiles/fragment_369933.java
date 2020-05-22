public static void main(String... args) throws Exception {
    BigInteger e = new BigInteger("2");
    e = e.pow(2048);
    BigInteger f =  e.add(BigInteger.ONE);
    System.out.println(e.gcd(f)); //1
    BigInteger d;
    if (e.gcd(f).equals(BigInteger.ONE)) {
        d = e.modInverse(f);
        System.out.println(d);
    } else {
        System.out.println("nop");
    }
}