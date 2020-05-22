public static final String INVALID_CHARACTERS = "^#%<>{}|";
private static final Pattern INVALID_PATTERN = Pattern.compile("["+Pattern.escape(INVALID_CHARACTERS)+"]");

public static boolean containsInvalidCharacters(String input) {
    return input != null && INVALID_PATTERN.matcher(input).find();
}