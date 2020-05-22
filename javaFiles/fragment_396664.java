static int numberOfDistinctOccurrence(String source, String token) {
    Pattern pattern = Pattern.compile("\\s*\\b" + token + "\\b\\s*");
    Matcher matcher = pattern.matcher(source);
    int c = 0;
    while (matcher.find()) {
        c++;
    }
    return c;
}