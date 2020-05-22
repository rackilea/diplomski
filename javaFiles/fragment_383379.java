public static void grid(char[][] array, int percentOfChar)
  {
    int charsToPlace = (int) (percentOfChar * array.length * array.length / 100.0);
    while (charsToPlace > 0)
    {
        int row = (int) (Math.random() * array.length);
        int column = (int) (Math.random() * array.length);
        if (array[row][column] != 'A');
        {
            array[row][column] = 'A';
            charsToPlace--;
            System.out.print(array[row][column] + "  ");
        }          
    }
    System.out.println();
  }