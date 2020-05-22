public static String convert(String input) {
    StringBuilder sb = new StringBuilder(input);
    Pattern p = Pattern.compile("\\b\\p{L}{3}");
    Matcher m = p.matcher(input);
    while (m.find()) {
        char firstChar = sb.charAt(m.start());
        if (Character.isUpperCase(firstChar)) {
            sb.setCharAt(m.start(), Character.toLowerCase(firstChar));
        } else {
            sb.setCharAt(m.start(), Character.toUpperCase(firstChar));
        }
    }
    return sb.toString();
}