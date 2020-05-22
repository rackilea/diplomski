private static int getDifferenceBetweenTwoArray(int[] array1 , int[] array2)
{
    int differenceCount = 0;
    //if you dont want to sort your original arrays, create temporary arrays
    int temp1[] = Arrays.copyOf(array1 , array1.length);
    int temp2[] = Arrays.copyOf(array2 , array2.length);
    Arrays.sort(temp1);
    Arrays.sort(temp2);

    for(Integer i : temp1)
    {
        if(Arrays.binarySearch(temp2, i) < 0)
            differenceCount++;
    }
    for(Integer i: temp2)
    {
        if(Arrays.binarySearch(temp1, i) < 0)
            differenceCount++;
    }   

    return differenceCount;
}