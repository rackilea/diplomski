for (Iterator<String> it: words; it.hasNext(); ) {
    String word : it.next();
    if (anyLetterNotInWord(letters, word) {
        it.remove();
    }
}