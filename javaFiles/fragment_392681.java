private static int indexOf(int value, int[] array)
{
    for (int i=0; i<array.length; i++)
    {
        if (array[i] == value)
            return i;
    }
    return -1;
}