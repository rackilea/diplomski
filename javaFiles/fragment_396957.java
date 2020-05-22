int [] [] sudoku = new int[10] [10];
// loop through all of the rows
for (int row = 0; row < 10; row++) {
    // loop through all columns for each row
    for (int column = 0; column < 10; column++) {
        // print out the sudoku value at that row and column
        System.out.print(sudoku[row] [column] + " ");
    }
    // at the end of the row, print a blank line to start the next row
    System.out.println();
}