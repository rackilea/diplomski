public static void main (String [] args)
{
    int[][] numbers = new int[5][5];

    int rows = 5;
    int columns = 5;

    numbers[0][0] = 30;
    numbers[0][1] = 29;
    numbers[0][2] = 28;
    numbers[0][3] = 27;
    numbers[0][4] = 26;

    numbers[1][0] = 26;
    numbers[1][2] = 25;
    numbers[1][2] = 24;
    numbers[1][3] = 23;
    numbers[1][4] = 22;

    int x, y;
    StringBuilder builder = new StringBuilder();
    for (x = 0;  x < rows; x++)
    {
        for (y = 0; y < columns; y++)
        {
            builder.append(numbers[x][y] + " ");
        }
        builder.append("\n");
    }
    JOptionPane.showMessageDialog(null, builder,"Arrays",JOptionPane.INFORMATION_MESSAGE);
    System.exit(0);
}