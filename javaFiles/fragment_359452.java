class BigDecRand {
    public static void main(String[] args) {
        String range = args[0];
        BigDecimal max = new BigDecimal(range + ".0");
        BigDecimal randFromDouble = new BigDecimal(Math.random());
        BigDecimal actualRandomDec = randFromDouble.divide(max,BigDecimal.ROUND_DOWN);

        BigInteger actualRandom = actualRandomDec.toBigInteger();
    }
}