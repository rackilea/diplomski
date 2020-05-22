public static void main(String[] args) throws Exception {
    test("August 20th, 2012");
    test("August 21st, 2012");
    test("August 22nd, 2012");
    test("August 23rd, 2012");
    test("August 24th, 2012");
}
static void test(String input) throws ParseException {
    String modified = input.replaceFirst("(?<=\\d)(?:st|nd|rd|th)", "");

    DateFormat originalFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
    DateFormat targetFormat = new SimpleDateFormat("yyyyMMdd");
    Date date = originalFormat.parse(modified);
    System.out.println(targetFormat.format(date));
}