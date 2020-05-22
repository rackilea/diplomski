boolean containsWhitespace = false;
for (int i = 0; i < text.length() && !containsWhitespace; i++) {
    if (Character.isWhitespace(text.charAt(i)) {
        containsWhitespace = true;
    }
}
return containsWhitespace;