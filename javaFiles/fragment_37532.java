private static final Pattern KEY_VALUE = Pattern.compile("\\G\\s*+(\\w++)=([^\\s\"]++|\"[^\"]*+\")(?:\\s++|$)");

public static Map<String, String> parseKeyValue(String kvString) {
    Matcher matcher = KEY_VALUE.matcher(kvString);

    Map<String, String> output = new HashMap<String, String>();
    int lastIndex = -1;

    while (matcher.find()) {
        output.put(matcher.group(1), matcher.group(2));
        lastIndex = matcher.end();
    }

    // Make sure that we match everything from the input string
    if (lastIndex != kvString.length()) {
        return null;
    }

    return output;
}