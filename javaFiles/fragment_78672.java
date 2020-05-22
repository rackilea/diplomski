public static int countOccurrence(char[] array, char character, int index)
{
    int counter = 0;
    if (index >= array.length)
        return 0;
    if (array[index] == character)
            counter++;
    counter += countOccurrence(array, character, index + 1);
    return counter;
}