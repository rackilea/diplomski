Pattern regex = Pattern.compile("(?<id>\\d+),(?<name>\\w+),(?<active>[01]),(?<predecessor>\\d+|null)");
Matcher regexMatcher = regex.matcher(yourString);
while (regexMatcher.find()) {
        // do something with regexMatcher.group("id")
        // do something with regexMatcher.group("name")
        // do something with regexMatcher.group("active")
        // do something with regexMatcher.group("predecessor")
}