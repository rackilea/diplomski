private static final Pattern STRING_FORMAT = Pattern.compile("(\\D+)(\\d+)");

public static final String padZeros(String s) {
    Matcher matcher = STRING_FORMAT.matcher(s);
    if (!matcher.matches() || s.length() > 10)
        throw new IllegalArgumentException("Invalid format");
    char[] result = new char[10];
    Arrays.fill(result, '0');
    String nonDigits = matcher.group(1);
    String digits = matcher.group(2);
    nonDigits.getChars(0, nonDigits.length(), result, 0);
    digits.getChars(0, digits.length(), result, 10 - digits.length());
    return String.valueOf(result);
}