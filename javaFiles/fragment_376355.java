int NumElements = NumRows * NumCols;

for (int i = 0; i < NumElementsToFill; ++i)
{
    int row = i / NumRows;
    int col = i % NumCols;
    array[row, col] = 1;
}

// Now shuffle the array
Random rnd = new Random();

for (int i = 0; i < NumElements; ++i)
{
    int irow = i / NumRows;
    int icol = i % NumCols;

    int swapWith = rnd.Next(i+1);
    int swapRow = swapWith / NumRows;
    int swapCol = swapWith % NumCols;

    byte temp = array[irow, icol];
    array[irow, icol] = array[swapRow, swapCol];
    array[swapRow, swapCol] = temp;
}