private static int medianOfThreeIndex(int [] a, int start, int end)
{
    int mid= start + (end-start)/2; //find the middle of the array

    int vs = a[start];
    int vm = a[mid];
    int ve = a[end];

    if (vs >= vm  && vm >= ve)
    {
        return mid;
    }
    else if (vm >= vs  && vs >= ve)
    {
        return start;
    }
    else
    {
        return end;
    }

}