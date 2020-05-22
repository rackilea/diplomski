private int countPossiblePlacementsInCol(int col, int d) {
    // I am assuming an empty cell is indicated by 0. In that case,
    // we can reuse the previous method to find the number of occurrences of d,
    // and the occurences of 0

    // first, find out if the digit already occurs in the row, return 0
    // if it does:
    if(countOccurrencesInCol(col, d) > 0) {
        return 0;
    }

    // next, return the number of times 0 occurs (the number of empty cells):
    return countOccurrencesInCol(col, 0);
}