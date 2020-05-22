private int countOccurrencesInCol(int col, int d) {
    // counter variable to count the number of occurrences
    int counter = 0;
    // matrix is the 2D array, the first index is the row, second is the column
    // loop through each index of the given column, checking for the digit, d
    for(int row = 0; row < matrix.length; row++) {
        // if a match is found...
        if(matrix[row][col] == d) {
            // increment the counter by one
            counter++;
        }
    }

    // return the final count
    return counter;
}