private static final String PATTERN = "\\d{1,7}(\\.\\d{1,2})?";

public static void main(final String[] args) {
    final Pattern ptrn = Pattern.compile(PATTERN);
    System.out.println(ptrn.matcher("1").matches());
    System.out.println(ptrn.matcher("1234567").matches());
    System.out.println(ptrn.matcher("12345678").matches());
    System.out.println(ptrn.matcher("1234567.").matches());
    System.out.println(ptrn.matcher("1234567.1").matches());
    System.out.println(ptrn.matcher("1234567.12").matches());
    System.out.println(ptrn.matcher("1234567.123").matches());
    System.out.println(ptrn.matcher("1.12").matches());
    System.out.println(ptrn.matcher(".12").matches());
}