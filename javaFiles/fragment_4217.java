private static String patternMatcher(String content, String patternText, int groupIndex) {
    Pattern pattern = Pattern.compile(patternText);
    Matcher matcher = pattern.matcher(content);

    if (matcher.find()) {
        return matcher.group(groupIndex);
    } else {
        return "";
    }
}

public static String getPackageName(String content) {
    return patternMatcher(content, ".*package\\s+(.*)\\s*\\;", 1);
}

public static String getClassName(String content) {
    return patternMatcher(content, ".*class\\s+(\\w+)[\\w\\s]+\\{", 1);
}

public static String getClassCode(String content) {
    return patternMatcher(content, ".*class.*\\{((.*\\s*)*)\\}", 1);
}

public static String getMethodName(String code) {
    String uncommentedCode = removeComments(code).trim();

    return patternMatcher(uncommentedCode,
            "(public|private|static|protected|abstract|native|synchronized) *([\\w<>.?, \\[\\]]*)\\s+(\\w+)\\s*\\([\\w<>\\[\\]._?, \\n]*\\)\\s*([\\w ,\\n]*)\\s*\\{",
            3);
}

public static String removeComments(String content) {
    return content.replaceAll("\\/\\*[\\s\\S]*?\\*\\/|([^:]|^)\\/\\/.*$", "$1 ").trim();
}