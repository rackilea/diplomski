public static void main(String[] args) {
    // CREATE TEST-DATA
    StringBuilder testSequenceBuilder = new StringBuilder();
    testSequenceBuilder.append("                                                                              ");
    testSequenceBuilder.append("CREDIT CARD TERMS                                                             ");
    testSequenceBuilder.append("ORDER IS ON HOLD FOR PREPAYMENT OF ORDER TOTAL + FREIGHT BY CREDIT CARD.      ");
    testSequenceBuilder.append("ORDER TOTAL DOES NOT REFLECT FREIGHT COSTS & WILL BE CHARGED AFTER ORDER      ");
    testSequenceBuilder.append("SHIPS. ORDER WILL SHIP _52_ WORKING DAYS FROM RECEIPT OF ALL APPROVALS &      ");
    testSequenceBuilder.append("RECEIPT OF CREDIT CARD FORM.                                                  ");
    testSequenceBuilder.append("                                                                              ");

    // TEST
    String testSequence = testSequenceBuilder.toString();

    // REGEX
    performAndPrintNanos(() -> {
        Pattern pattern = Pattern.compile("ORDER WILL SHIP _(?<g>[0-9]+)_ WORKING DAYS",
                Pattern.CASE_INSENSITIVE); // Edited with Kuzeko's pretty example. If you want the pattern to be case-sensitive, just remove the second param of Pattern.compile
        Matcher matcher = pattern.matcher(testSequence);
        if (matcher.find()) {
            System.out.println("OUTPUT-regex: " + matcher.group(1));
        }
    });

    // SUBSTRING
    performAndPrintNanos(() -> {
        String pre = "ORDER WILL SHIP _";
        String suf = "_ WORKING DAYS";
        System.out.println("OUTPUT-java: "
                + testSequence.substring(testSequence.indexOf(pre) + pre.length(), testSequence.indexOf(suf)));
    });
}

private static void performAndPrintNanos(Runnable runnable) {
    long startNanos = System.nanoTime();
    runnable.run();
    System.out.println(System.nanoTime() - startNanos);
}