public static char getRight(char[][] factGrid, int cRow, int cCol) {
    if(factGrid[0].length > (cCol + 1)) {
        return factGrid[cRow][(cCol + 1)];
    } else {
        return '';
    }
}