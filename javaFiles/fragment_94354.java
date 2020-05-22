private boolean checkRight(int row, int col, String word, char[][] puzzle) {
    //Checking right direction
    for(int letter = 1; letter < word.length(); letter++) {
        if(puzzle[row][col + letter] != word.charAt(letter)) {
            return false;
        }
    }
    return true;
}