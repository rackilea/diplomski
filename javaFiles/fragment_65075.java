public int findTotalLength(int[][] array)
{
    int sum = 0;
    for (int[] subArray : array)
    {
        sum += subArray.length;
    }
    return sum;
}