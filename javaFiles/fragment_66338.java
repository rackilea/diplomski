String testWord = "test";
    char[] word = new char[testWord.length() * 2];
    for (int i = 0; i < word.length; i+=2) {
        word[i] = '_';
        word[i + 1] = ' ';
    }