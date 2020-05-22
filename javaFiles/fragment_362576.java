public static String removeSurrogates(String query) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < query.length(); i++) {
        char c = query.charAt(i);
        // !isSurrogate(c) in Java 7
        if (!(Character.isHighSurrogate(c) || Character.isLowSurrogate(c))) {
            sb.append(firstChar);
        }
    }
    return sb.toString();
}