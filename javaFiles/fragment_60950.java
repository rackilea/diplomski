private static String replaceRepeatedly(String text, Map<String, String> map) {
    if(map.isEmpty()) return text;
    String pattern = map.keySet().stream()
        .sorted(Comparator.comparingInt(String::length).reversed())
        .map(Pattern::quote)
        .collect(Collectors.joining("|"));
    Matcher m = Pattern.compile(pattern).matcher(text);
    if(!m.find()) return text;
    StringBuffer sb;
    do {
        sb = new StringBuffer();
        do m.appendReplacement(sb, Matcher.quoteReplacement(map.get(m.group())));
           while(m.find());
        m.appendTail(sb);
    } while(m.reset(sb).find());
    return sb.toString();
}