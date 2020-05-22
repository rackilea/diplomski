private static boolean recur(String word, int length) {
    int nextLength = length;
    String nextWord = word;
    while( true ) {
        if(nextLength == 1 || nextLength == 2)
            return false;
        if(nextLength == 0)
            return true;
        if(words[nextLength].contains(nextWord.substring(0, nextLength))) {
            nextWord = nextWord.substring(nextLength);
            nextLength = nextWord.length() - nextLength;
        } else {
            nextWord = nextWord;
            nextLength = nextLength - 1;
        }
    }
}