private static int findMinPos( int[] data, int cur, int minPosSoFar )
{
    if(cur < data.length)
    {
        if(data[cur] < data[minPosSoFar]) // set new minimum to position cur
        {
            return findMinPos(data, cur + 1, cur);
        }
        else // keep old minimum
        {
            return findMinPos(data, cur + 1, minPosSoFar);
        }
    }

    return minPosSoFar;
}