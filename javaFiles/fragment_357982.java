public static void quickSort(int[] a, int start, int end)
{
    if(end-start > 0) //base case for zero or one element? already 
    {
        int pivotPosn = partition(a,start,end);
        quickSort(a,start, pivotPosn-1);
        quickSort(a,pivotPosn+1, end);
    }
}