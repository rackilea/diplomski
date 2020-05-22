for (int row = 0; row < cells.length ; row++)
    for (int col = 0 ; col < cells[row].length ; col++) {
       int n = neighbours(row,col);

       if (n > 3  ||  n < 2)
           tempCells[row][col] = false;
       else if (n == 3)
           tempCells[row][col] = true;
       else
           tempCells[row][col] = cells[row][col];
    }