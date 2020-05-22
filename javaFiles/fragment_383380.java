class IntegerSquareArray
{
    public final int length;
    int[][] array;
    IntegerSquareArray(int length)
    {
        this.length = length;
        this.array = new int[length][length];
    }

    public int getValue(int row, int column)
    {
        if (row < length && column < length)
            return array[row][column];
        throw new IllegalArgumentException();
    }

    public void setValue(int row, int column, int value)
    {
        if (row < length && column < length)
            array[row][column] = value;
        else throw new IllegalArgumentException();
    }
}