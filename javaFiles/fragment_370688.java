private int countPossiblePlacementsInCol(int col, int d) {
    //start the same as the previous method:
    if(countOccurrencesInCol(col, d) > 0) {
        return 0;
    }

    int counter = 0;
    // this time, for each cell in the column, you must check that it is a valid move:
    for(int row = 0; row < matrix.length; row++) {
        if(countOccurrencesInRow(row, d) == 0 &&
           countOccurencesInSquare(row, col, d) == 0) {
            counter++
        }
    }
}