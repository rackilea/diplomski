public static boolean checkUp(char[][] puzzle, String word, int i, int j) {
    if (i - word.length() >= 0) {
        for (int offset = 0; offset < word.length(); offset++) {
            if (puzzle[i - offset][j] != word.charAt(offset)) {
                return false;
            }
        }
        return true;
    } else {
        return false;
    }
}