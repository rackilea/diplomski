int x_left = (row - (row % 3));
int y_top = (col - (col % 3));
for(int i=0; i<3; i++) {
  for(int j=0; j<3; j++) {
     if(sudoku[i + x_left][j + y_top] != 0) {
       alreadyInUse[currentIndex] = sudoku[i + x_left][j + y_top];
       currentIndex++;
     }
  }
}