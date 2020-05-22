for(int i=1; i< 10; i++){
            if(!conflictAt(sudoku, row, col, i)){
                sudoku.setValue(row, col, i);

                //continue recursively with the next cell
                isSolvable(sudoku, nextCell[0], nextCell[1]);  <------ here
            }