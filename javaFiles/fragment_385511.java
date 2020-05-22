private Word getLongestWordFromList(List<Word> listOfWords) {
    Word longestWord = null;
    for (Word word : listOfWords) {
        if (longestWord == null || word.length() > longestWord.length()) {
            longestWord = word;
        }
    }
    return longestWord;
}