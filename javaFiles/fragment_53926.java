Pattern regex = Pattern.compile("@[^@]+@");
Matcher regexMatcher = regex.matcher(subjectString);
while (regexMatcher.find()) {
    // matched text: regexMatcher.group()
    // match start: regexMatcher.start()
    // match end: regexMatcher.end()
}