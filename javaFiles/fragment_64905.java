static void test(String input) {
    System.out.println("'" + input + "'");
    int lastEnd = 0;
    Matcher m = Pattern.compile("\\G\\s+(foo|bar)").matcher(input);
    while (m.find()) {
        System.out.printf("  g0='%s' (%d-%d), g1='%s' (%d-%d)%n",
                          m.group(), m.start(), m.end(),
                          m.group(1), m.start(1), m.end(1));
        lastEnd = m.end();
    }
    if (lastEnd == input.length())
        System.out.println("  OK");
    else
        System.out.println("  Incomplete: Last match ended at " + lastEnd);
}