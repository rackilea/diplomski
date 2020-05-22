int lo = 0;
    int hi = count-1;
    int index = 0;
    boolean found = false;
    while (!found && lo < hi)
    {
        int mid = lo + ((hi - lo) / 2);
        if (a[mid] == key)
        {
            found = true;
            index = mid;
        }
        else if (a[mid] > key)
        {
            hi = mid;
            index = hi;
        }
        else
        {
            lo = mid +1;
            index = lo;
        }
    }
    return index;