public static boolean onEdge(int n, int numRows, int numCols)
{
    int row = n / numCols; // int / int divides to floor
    int column = n % numCols; // column within row

    // check if n is in the beginning or final row
    if (row == 0 || row == numRows - 1)
        return true;

    // check if n is in the first or last column
    if (column == 0 || column == numCols -1)
        return true;

    return false;
}