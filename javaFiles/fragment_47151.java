public static Duration parseHuman(String text) {
    Matcher m = Pattern.compile("\\s*(?:(\\d+)\\s*(?:hours?|hrs?|h))?" +
                                "\\s*(?:(\\d+)\\s*(?:minutes?|mins?|m))?" +
                                "\\s*(?:(\\d+)\\s*(?:seconds?|secs?|s))?" +
                                "\\s*", Pattern.CASE_INSENSITIVE)
                       .matcher(text);
    if (! m.matches())
        throw new IllegalArgumentException("Not valid duration: " + text);
    int hours = (m.start(1) == -1 ? 0 : Integer.parseInt(m.group(1)));
    int mins  = (m.start(2) == -1 ? 0 : Integer.parseInt(m.group(2)));
    int secs  = (m.start(3) == -1 ? 0 : Integer.parseInt(m.group(3)));
    return Duration.ofSeconds((hours * 60L + mins) * 60L + secs);
}