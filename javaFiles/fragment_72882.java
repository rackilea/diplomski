void main(int[][] matrix)
{
    System.out.println(Math.max(columnMaxSequence(matrix), rowMaxSequence(matrix)));
}

public int columnMaxSequence(int[][] matrix)
{
    int max = 0;

    for(int i = 0; i < matrix[0].length; i++) // Column Index
    {
        int tempMax = 0;
        for(int j = 0; j < matrix.length; j++) // Row Index
        {
            if(matrix[j][i] == 1)
            {
                tempMax = 1;
                for(int k = j+1; k < matrix.length; k++)
                {
                    if(matrix[k][i] == 1)
                        tempMax++;
                    else break;
                }
                if(max < tempMax)
                    max = tempMax;
            }
        }
    }

    return max;
}

public int rowMaxSequence(int[][] matrix)
{
    int max = 0;

    for(int i = 0; i < matrix.length; i++)
    {
        int tempMax = 0;
        for(int j = 0; j < matrix[0].length; j++)
        {
            if(matrix[i][j] == 1)
            {
                tempMax = 1;
                for(int k = j+1; k < matrix[0].length; k++)
                {
                    if(matrix[i][k] == 1)
                        tempMax++;
                    else break;
                }
                if(max < tempMax)
                    max = tempMax;
            }
        }
    }

    return max;
}