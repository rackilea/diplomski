public static char[][] generatePuzzleGrid(String[] words, int wordAmount) {
    if(wordAmount>words.length){
        wordAmount = words.length;
    }
    char[][] puzzleGrid = new char[wordAmount][wordAmount];
    for (int across = 0; across < wordAmount; across++) {
        for (int down = 0; down < words[across].length(); down++) {
            puzzleGrid[across][down] = words[across].charAt(down);/////////////////
        }
    }
    return puzzleGrid;
}