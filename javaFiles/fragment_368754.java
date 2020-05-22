public Sudoku(int a, int b, int array[][]){
    cellHeight = a; // Changing these two instance variables will *NOT*
    cellWidth = b;  // retrofit your subGrid to a new size.
    size = cellHeight*cellWidth;
    subGrid = new int[size][size];
    for(int i = 0; i<size; i++){
        for(int j = 0; j<size; j++){
            int temp = array[i][j];
            sudGrid[i][j] = temp;
        }
    }
}