private String removePoundSign(final String input) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
        char ch = input.charAt(i);
        if (Character.isDigit(ch)) {
            builder.append(ch);
        }
    }
    return builder.toString();
}