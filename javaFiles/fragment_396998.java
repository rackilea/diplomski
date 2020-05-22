private static Pattern toRegex(String patternFromDb) {
    StringBuffer regex = new StringBuffer();
    Matcher m = Pattern.compile("\\.{1,}|\\*{1,}|[^.*]+").matcher(patternFromDb);
    while (m.find()) {
        String s = m.group();
        switch (s.charAt(0)) {
            case '.':
                // leave dots as they are
                break;
            case '*':
                m.appendReplacement(regex, ".*"); // replace * with .*
                break;
            default:
                m.appendReplacement(regex, Matcher.quoteReplacement(s)); // escape literal match
        }
    }
    return Pattern.compile(m.appendTail(regex).toString());
}