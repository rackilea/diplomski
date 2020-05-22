private static boolean recur(String word, int length) {
    if(length == 1 || length == 2)
        return false;
    if(length == 0)
        return true;
    int nextLength;
    String nextWord;
    if(words[length].contains(word.substring(0, length))) {
      nextWord = word.substring(length);
      nextLength = word.length() - length;
    } else {
      nextWord = word;
      nextLength = length - 1;
    }
    return recur(nextWord, nextLength);
}