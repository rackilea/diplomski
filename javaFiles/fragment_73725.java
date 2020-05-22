public static <E extends Comparable<E>> void selectionSort(E[] list)
{
    for(int i=0; i<list.length -1; i++)
    {
        int iSmall = i;

        for(int j=i+1; j<list.length; j++)
        {
            if(list[iSmall].compareTo((list[j])) > 0  )
            {
                iSmall = j;
            }
        }
        E iSwap = list[iSmall];
        list[iSmall] = list[i];
        list[i] = iSwap;

    }
}