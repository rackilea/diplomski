public static BigInteger findIn(List<BigInteger> source, String value) {
    return source.stream()
            .filter(bi -> bi.equals(new BigInteger(String.valueOf(value))))
            .findFirst()
            .orElse(null);
}