private static double[][] toArray(DenseMatrix64f matrix) 
{
    double array[][] = new double[matrix.getNumRows()][matrix.getNumCols()];
    for (int r=0; r<matrix.getNumRows(); r++)
    { 
        for (int c=0; c<matrix.getNumCols(); c++)
        {
            array[r][c] = matrix.get(r,c);
        }
    }
    return array;
}