longestWord(String sentence) {
    if (sentence.indexOf(' ') == -1) {      // IF sentence only has one word
        return sentence;
    }
    String firstWord = getFirstWord(sentence);//how you're doing it now
    String rest = getRest(sentence);//Just the sentence without the first word (and first space...)
    String secondWord = longestWord(rest);
    return firstWord.length >= secondWord.length ? firstWord : secondWord;
}