Pattern regex = Pattern.compile("^@(\\d{6})@ *(\\d{9})\\[ (\\d{6})@ (\\d{2})");
Matcher regexMatcher = regex.matcher(subjectString);
if (regexMatcher.find()) {
    String firstGroup  = regexMatcher.group(1);
    // 123456
    String secondGroup = regexMatcher.group(2);
    // 123456789
    String thirdGroup  = regexMatcher.group(3);
    // 123456
    String fourthGroup = regexMatcher.group(4);
    // 12
}