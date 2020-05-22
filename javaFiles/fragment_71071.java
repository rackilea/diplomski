private static void testMatch(final String haystack, final String needle) {
    final Matcher matcher = createHighlightPattern(needle).matcher(haystack);
    if (!matcher.find())
        System.out.println("Failed to find pattern " + needle);
    while (matcher.find())
        System.out.println("Found additional match: " + matcher.group() +
                           " for pattern " + needle);
}

public static void main(final String[] args) {
    final String testString = "java,c++,hibernate,.net,asp.net,c#,spring";
    testMatch(testString, "java");
    testMatch(testString, "c++");
    testMatch(testString, ".net");
    testMatch(testString, "c#");
}