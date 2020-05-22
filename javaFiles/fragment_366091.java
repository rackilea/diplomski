public static String extractPattern(String string, String pattern) {
    Pattern searchPattern = Pattern.compile(pattern);
    Matcher matcher = searchPattern.matcher(string);
    if(matcher.find()){
        System.out.println("Pattern found");
        return matcher.group();
    }
    throw new IllegalArgumentException("Match not found");
}