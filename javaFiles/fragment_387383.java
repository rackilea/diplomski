List<String> matchList = new ArrayList<String>();
try {
    Pattern regex = Pattern.compile("([0-9.]+)|([+*/\\-])");
    Matcher regexMatcher = regex.matcher(subjectString);
    while (regexMatcher.find()) {
        matchList.add(regexMatcher.group());
    } 
} catch (PatternSyntaxException ex) {
    // Syntax error in the regular expression
}