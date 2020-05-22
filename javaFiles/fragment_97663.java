public static String underscoreToCapital(String text) {
    // This will be a bit bigger than necessary, but that shouldn't matter.
    StringBuilder builder = new StringBuilder(text.length());
    boolean capitalizeNext = false;
    for (int i = 0; i < text.length(); i++) {
        char c = text.charAt(i);
        if (c == '_') {
            capitalizeNext = true;
        } else {
            builder.append(capitalizeNext ? Character.toUpperCase(c) : c);
            capitalizeNext = false;
        }
    }
    return builder.toString();
}