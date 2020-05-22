static int findShortestString(String[] paths, int lo, int hi) 
{
    if (lo==hi)
        return lo;

    int ShortestIndexSoFar = findShortestString(paths, lo+1, hi);
    if(safeStringLength(paths[ShortestIndexSoFar]) < safeStringLength(paths[lo]))
        return ShortestIndexSoFar;
    else
        return lo;
}  

static int safeStringLength(String str)
{
    if(str == null)
        return Integer.MAX_VALUE;
    return str.length();
}