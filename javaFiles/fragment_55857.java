public static String overlay1(String value, String with) {
    String result = null;
    if (value.length() != with.length()) {
        throw new IllegalArgumentException("The two String's must be the same length");
    } else {
        StringBuilder sb = new StringBuilder(value);
        for (int index = 0; index < value.length(); index++) {
            char c = with.charAt(index);
            if (!Character.isWhitespace(c)) {
                sb.setCharAt(index, c);
            }
        }
        result = sb.toString();
    }
    return result;
}