public HangmanWord() {
    int randomPossibleWord = (int) (Math.random() * possibleWords.length-1);
    word = possibleWords[randomPossibleWord];
    progress = new char[word.length()];
    Arrays.fill(progress,'-');
}