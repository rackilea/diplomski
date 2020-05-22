public static void main(String[] args) throws ParseException {
    final String dollarsA = "$199.00";
    final String real = "R$ 399,00";
    final String dollarsB = "£25.00";
    final String tailingEuro = "90,83 €";
    final String dollarsC = "$199.00";
    final String dirham = "AED 449.00";

    System.out.println(parse(dollarsA, Locale.US));
    System.out.println(parse(real, Locale.FRANCE));
    System.out.println(parse(dollarsB, Locale.US));
    System.out.println(parse(tailingEuro, Locale.FRANCE));
    System.out.println(parse(dollarsC, Locale.US));
    System.out.println(parse(dirham, Locale.US));
}