Pattern regex = Pattern.compile("[+-]?(?:\\d*\\.\\d+|\\d+)");
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) {
    // matched text: regexMatcher.group()
    // match start: regexMatcher.start()
    // match end: regexMatcher.end()
}