Pattern pattern = Pattern.compile("\"([^\"]+)\"|'([^']+)'|\\S+");
List<String> testStrings = Arrays.asList("foo bar", "\"foo bar\"","'foo bar'", "'foo bar", "\"'foo bar\"", "foo bar'", "foo bar\"", "\"foo bar\" \"stack overflow\"", "\"foo' bar\" \"stack overflow\" how do you do");
for (String testString : testStrings) {
    int count = 1;
    Matcher matcher = pattern.matcher(testString);
    System.out.format("* %s%n", testString);
    while (matcher.find()) {
        System.out.format("\t* group%d: %s%n", count++, matcher.group(1) == null ? matcher.group(2) == null ? matcher.group() : matcher.group(2) : matcher.group(1));
    }
}