Set<String> usedLetters = new HashSet<String>();

boolean isUsedLetter(String letter) {
    if (usedLetters.contains(letter)) {
        return true;
    } else {
        usedLetters.add(letter);
        return false;
    }
}