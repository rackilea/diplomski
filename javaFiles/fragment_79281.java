public static int IndexOf(int value, int[] array)
{
    for (int i=0; i < array.length; i++)
    {

        if(array[i] == value)
        {            
            System.out.println("Linear search: Number of comparisons = " + (i + 1));
            return i;
        }
    }

    return -1;
}