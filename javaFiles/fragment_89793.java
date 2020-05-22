private static int zad4(char[] word, char[] arr) {
    int countWord = 0;
    for (int p = 0; p < arr.length; p++) {
        for (int i = 0; i < word.length && p + i < arr.length; i++) {
            if (word[i] != arr[p + i]) {
                break;
            } else if (i + 1 == word.length) {
                countWord++;
            }
        }
    }
    return countWord;
}