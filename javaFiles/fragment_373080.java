public static void main(String[] args)
{
    int[][] table = new int[5][8];

    for (int row = 0; row < 5; row++)
    {
        for (int column = 0; column < 4; column++)
        {
            // left side entry [row][0..3]
            // each entry is 5 more than the entry left of it 
            table[row][column] = column * 5 + row + 1;

            // right side entry [row][7..4] mirrored from corresponding entry [row][0..3]
            // i.e. column 7 <- column 0, column 6 <- column 1, etc.
            table[row][7 - column] = table[row][column];
        }
    }

    for (int row = 0; row < 5; row++)
    {
        for (int column = 0; column < 8; column++)
        {
            System.out.format("%4d", table[row][column]);
        }
        System.out.println();
    }
}