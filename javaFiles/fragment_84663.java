private String changeFirstCharCase(String word) {
    return changeFirstCharCase(word,false);
}

private String changeFirstCharCase(String word,boolean toUpperCase) {
    return toUpperCase
        ? Character.toUpperCase(word.charAt(0)) + word.substring(1)
        : Character.toLowerCase(word.charAt(0)) + word.substring(1);
}