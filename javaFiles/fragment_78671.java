public static int countOccurrence(char[] array, char character)
{
    int counter = 0;
    for(int index = 0; index < array.length; ++index)
    {
        if (array[index] == character)
        {
            counter++;
        }
    }
    return counter;
}