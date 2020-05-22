public static int BinaryIndexOf(int value, int [] array)
{
    int start = 0;
    int end = array.length -1;
    int middle;
    int loopCount = 0;
    while (end >= start)
    {
        loopCount++;
        middle = (start + end ) /2;
        if (array[middle]== value)
        {
            System.out.println("Binary search: Number of times looped = " + loopCount); 
            return middle;
        }
        if (array[middle]< value)
            start = middle + 1;
        else 
            end = middle - 1;
    }
    System.out.println("Binary search: Number of times looped = " + loopCount);
    return -1;

}