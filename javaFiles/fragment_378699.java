private static String convert(double number) {
    int n = 10;  // constant?
    BigDecimal bd = new BigDecimal(number);
    BigDecimal mult = new BigDecimal(2).pow(n);
    bd = bd.multiply(mult);
    BigInteger bi = bd.toBigInteger();
    StringBuilder str = new StringBuilder(bi.toString(2));
    while (str.length() < n+1) {  // +1 for leading zero
        str.insert(0, "0");
    }
    str.insert(str.length()-n, ".");
    return str.toString();
}