public static String toggleString(String sentence) {
    StringBuilder toggled = new StringBuilder(sentence.length());
    for (char letter : sentence.toCharArray()) {
        if(Character.isUpperCase(letter)) {
            letter = Character.toLowerCase(letter);
        } else if(Character.isLowerCase(letter)) {
            letter = Character.toUpperCase(letter);
        }

        toggled.append(letter);

    }
    return toggled.toString();
}