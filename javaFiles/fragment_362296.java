public static String convert(String input) {
    Pattern p = Pattern.compile("\\b(\\p{L})(?=\\p{L}{2})");
    Matcher m = p.matcher(input);
    return m.replaceAll(match -> {
        char ch = match.group().charAt(0);
        if (Character.isUpperCase(ch)) {
            return "" + Character.toLowerCase(ch);
        }
        return "" + Character.toUpperCase(ch);
    });
}