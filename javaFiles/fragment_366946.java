public class TokenReplacer {

    private Pattern tokenPattern;

    public TokenReplacer() {
        tokenPattern = Pattern.compile("\\{([^}]+)\\}");
    }

    public String replaceTokens(String text, Map<String, String> valuesByKey) {
        StringBuilder output = new StringBuilder();
        Matcher tokenMatcher = tokenPattern.matcher(text);

        int cursor = 0;
        while (tokenMatcher.find()) {
            // A token is defined as a sequence of the format "{...}".
            // A key is defined as the content between the brackets.
            int tokenStart = tokenMatcher.start();
            int tokenEnd = tokenMatcher.end();
            int keyStart = tokenMatcher.start(1);
            int keyEnd = tokenMatcher.end(1);

            output.append(text.substring(cursor, tokenStart));

            String token = text.substring(tokenStart, tokenEnd);
            String key = text.substring(keyStart, keyEnd);

            if (valuesByKey.containsKey(key)) {
                String value = valuesByKey.get(key);
                output.append(value);
            } else {
                output.append(token);
            }

            cursor = tokenEnd;
        }
        output.append(text.substring(cursor));

        return output.toString();
    }

}