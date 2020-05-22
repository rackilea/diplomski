public static int[] eliminateduplicates(int[] numbers)
{
    boolean[] tracker = new boolean[10];
    int arraysize = 0; 

    for(int k = 0; k < numbers.length; k++)
    {
        if(tracker[numbers[k]] == false)
        {
            arraysize++;
            tracker[numbers[k]] = true;
        }
    }

    int[] singles = new int[arraysize];

    for(int l = 0, count = 0; l < tracker.length; l++)
    {
        if(tracker[l] == true)
        {
            singles[count++] = l;
        }
    }

    return singles;
}