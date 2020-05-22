public class Test {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        char decimalSeparator = decimalFormat.getDecimalFormatSymbols().getDecimalSeparator();

        // prints 123.456
        System.out.println(decimalFormat.format(123456 / 1000.0));

        // 9,223,372,036,854,775,807
        System.out.println(decimalFormat.format(Long.MAX_VALUE));

        // 9,223,372,036,854,776, not 9,223,372,036,854,776.807, as double's resolution is not sufficient
        System.out.println(decimalFormat.format(Long.MAX_VALUE / 1000.0));

        // 9,223,372,036,854,775.807
        BigInteger[] divAndRem = new BigInteger(Long.toString(Long.MAX_VALUE))
                .divideAndRemainder(new BigInteger("1000"));
        System.out.println(decimalFormat.format(divAndRem[0]) 
                + decimalSeparator + divAndRem[1]);

        // using String manipulation
        String longString = decimalFormat.format(Long.MAX_VALUE);
        System.out.println(new StringBuilder(longString).replace(
                longString.length() - 4, 
                longString.length() - 3, 
                Character.toString(decimalSeparator)));
    }
}