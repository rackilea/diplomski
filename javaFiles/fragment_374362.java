public void alphabetize() {
    int loc;
    loc = word.indexOf(" ");
    String wordOne = word.substring(0, loc);
    String wordTwo = word.substring(loc + 1, word.length());
    if (wordOne.compareTo(wordTwo) > 0) {
        changedWord = wordTwo + " " + wordOne;
    } else {
        changedWord = wordOne + " " + wordTwo;
    }
}