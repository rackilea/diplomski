List<String> matchList = new ArrayList<String>();
try {
    Pattern regex = Pattern.compile("[+*/]|(?<=\\s)-");
    Matcher regexMatcher = regex.matcher(subjectString);
    while (regexMatcher.find()) {
        matchList.add(regexMatcher.group());
    } 
} catch (PatternSyntaxException ex) {
    // Syntax error in the regular expression
}