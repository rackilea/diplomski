try {
    Pattern regex = Pattern.compile("(?:/\\*[^;]*?\\*/)|(?:--[^;]*?$)", Pattern.DOTALL | Pattern.MULTILINE);
    Matcher regexMatcher = regex.matcher(subjectString);
    while (regexMatcher.find()) {
        // matched text: regexMatcher.group()
        // match start: regexMatcher.start()
        // match end: regexMatcher.end()
    } 
} catch (PatternSyntaxException ex) {
    // Syntax error in the regular expression
}