public static int[] sumTableRows(int[][] table)
{
    int rows = table.length;
    int cols = table[0].length;

    int[] sum = new int[rows];//make an array for sums

    for(int i=0; i<rows; i++) {

        for(int j=0; j<cols; j++){//iterate over all vars in the table array
            int temp  = table[i][j];//take value in point (i,j)
            sum[i] += temp;//sum it in sum[i].
        }
    }
    return sum;   //return the 1D array  
}