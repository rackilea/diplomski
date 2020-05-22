for (int i = 0; i < matrix.length; i++) 
{
    for (int j = 0; j < matrix[i].length; j++) 
    {
        if (i == 0 || j == 0 || i == matrix.length - 1 || j == matrix[i].length - 1)
        {
            System.out.printf("On [%d, %d] is on the border.", i, j);
        }
    }
}