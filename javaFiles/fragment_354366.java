List<String> matchList = new ArrayList<String>();
try {
    Pattern regex = Pattern.compile("if\\s*\\([^\\{]*\\{(?:[ \t]*//.*)?[ \t]*(?:[\r\n]*[ \t]*(?://.*)?)*[\r\n]*[ \t]*(?://.*)?}");
    Matcher regexMatcher = regex.matcher(subjectString);
    while (regexMatcher.find()) {
        matchList.add(regexMatcher.group());
    } 
} catch (PatternSyntaxException ex) {
    // Syntax error in the regular expression
}