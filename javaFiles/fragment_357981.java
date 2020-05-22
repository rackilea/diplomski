private static int partition(int [] a, int start, int end)
{
    int boundary,pivotPosn, pivot,bigStart;

    pivotPosn = start;
    pivot = a[pivotPosn];
    boundary = start;

    //Got rid of bigStart - it's not needed...
    swap(a,pivotPos,end); //Move your pivot value to the "right" or end of array

    // Note - it is fine to store the pivot at the "left" or start as
    // the OP originally did - in which case the following for
    // loop should run from start+1 to end inclusive and the 
    // boundary++ would come before the swap.

    for(int curr = start; curr<end;curr++)
    {
        if(a[curr]<pivot)
        {

            swap(a,boundary,curr);
            boundary++;
        }
    }
    swap(a,end,boundary); //swap your pivot value back to its final place
    return boundary;
}