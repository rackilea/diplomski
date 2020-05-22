public static void main(String[] args) {
    long x = 1452610545672622396L;

    BigInteger bigX = BigInteger.valueOf(x);
    bigX = bigX.shiftLeft(21).xor(bigX).and(new BigInteger("ffffffffffffffff", 16));

    System.out.println(bigX); // 12043412836254060860
    System.out.println(bigX.longValue()); // -6403331237455490756
}