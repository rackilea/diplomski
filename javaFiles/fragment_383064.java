public static void main(String[] args) {
    test("foo  tickets 456 ");
    test("42");
    test(" 1 A 3");
    test("4 tickets");
    test("billets 2");
}
public static void test(String haystack) {
    System.out.println(haystack);
    Matcher m = Pattern.compile("[^0-9]*([0-9]+)[^0-9]*").matcher(haystack);
    if (m.matches()) {
        System.out.println("  Needle was found in positions " + m.start(1) + " thru " + m.end(1));
        System.out.println("  Number from haystack is " + m.group(1)); 
    } else {
        System.out.println("  Haystack doesn't have exactly 1 needle");
    }
}