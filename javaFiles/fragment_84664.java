private String changeFirstCharCase(String word) {
    return Character.toLowerCase(word.charAt(0)) + word.substring(1);
}

private String changeFirstCharToUpperCase(String word) {
    return Character.toUpperCase(word.charAt(0)) + word.substring(1);
}