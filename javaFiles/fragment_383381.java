public static void grid3(IntegerSquareArray integerSquareArray,
    int percentOfChar)
{
    int charsToPlace = (int) (percentOfChar * integerSquareArray.length
        * integerSquareArray.length / 100.0);
    while (charsToPlace > 0)
    {
        int row = (int) (Math.random() * integerSquareArray.length);
        int column = (int) (Math.random() * integerSquareArray.length);
        if (integerSquareArray.getValue(row, column) != 'A')
        {
            integerSquareArray.setValue(row, column, 'A');
            charsToPlace--;
            System.out.print(integerSquareArray.getValue(row, column) + "  ");
        }
    }
    System.out.println();
}