public static boolean hasAllPhrasesInInput(List<String> phrases, String input) {
    Set<String> phrasesToFind = new HashSet<String>();
    StringBuilder sb = new StringBuilder();
    for (String phrase : phrases) {
        if (sb.length() > 0) {
            sb.append('|');
        }
        sb.append(Pattern.quote(phrase));
        phrasesToFind.add(phrase.toLowerCase());
    }
    Pattern pattern = Pattern.compile(sb.toString(), Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
        phrasesToFind.remove(matcher.group().toLowerCase());
        if (phrasesToFind.isEmpty()) {
            return true;
        }
    }
    return false;
}