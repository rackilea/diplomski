public static void main(String[] args) {
    System.out.println(format(-0.023));
    System.out.println(format(12.123));
    System.out.println(format(-12.345));
    System.out.println(format(-0.123));
    System.out.println(format(-1.777));
}

public static String format(double number) {
    DecimalFormat df = new DecimalFormat("#,##0.0");
    df.setRoundingMode(RoundingMode.HALF_UP);
    String formattedValue = df.format(number);
    formattedValue = formattedValue.replaceAll("^-(?=0(\\.0*)?$)", "");
    return formattedValue;
}