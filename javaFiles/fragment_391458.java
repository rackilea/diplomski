private static List<Character> all = new ArrayList<Character>(); //your own collection chars
private static final int MAX_LENGTH = 10; //max password length
static {
    // add '0' to '9' and 'A' to 'Z' here in the same manner. 
    for (int i = 'a'; i <= 'z'; i++) 
        all.add((char)i);
}

public void go() {
    for (int i = 1; i <= MAX_LENGTH; i++)
        inputWordsWithLength(i);
}

// entrypoint for a word with a certain length
private void inputWordsWithLength(int wordlength) {
    char[] word = new char[wordlength];
    start(word);
    doForRange(word, 0, wordlength - 1);
}

// this method is responsible for character mutation on only one index,
// and recursively calls itself
private void doForRange(char[] word, int index, int lastindex) {
    for (char c : all) {
        word[index] = c;
        for (int i = index + 1; i <= lastindex; i++) {
            doForRange(word, i, lastindex);
        }
        inputWordIntoGUI(word);
    }
}

// inject the word into your GUI
private void inputWordIntoGUI(char[] word) {
    //implement this yourself.
}

// set the value on 'aaa', for example. Not necessary, but failsafe.
private void start(char[] word) {
    for (int i = 0; i < word.Length; i++)
        word[i] = all[0];
}