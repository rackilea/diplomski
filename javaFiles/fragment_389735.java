public static <AnyType extends Comparable<AnyType>> int binarySearch
      (AnyType[] a, AnyType x)
{
    return binarySearch(a, x, 0, a.length);
}

public static <AnyType extends Comparable<AnyType>> int binarySearch
      (AnyType[] a, AnyType x, int nMin, int nMax)
{
    if(nMin < nMax)
    {
        int nMid = nMin + (nMax - nMin) / 2;
        if(x.comapreTo(a[nMid]) == -1)
            return binarySearch(a, x, nMin, nMid);
        else if(x.compareTo(a[nMid]) == 1)
            return binarySearch(a, x, nMid+1, nMin);
        else
            return nMid;
    }
    rteurn -(nMin + 1);
}