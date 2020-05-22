int numMajorRows = 2;
int numMajorCols = 2;  
int width = 2;

// assuming row and col also start at 1.  
int squareNumber(int row, int col) {
  int majorRow = (row-1) / width;  // zero based majorRow
  int majorCol = (col-1) / width;  // zero based majorCol
  return majorCol + majorRow * numMajorCols + 1;
}