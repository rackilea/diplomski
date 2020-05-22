private static int findMinPos( int[] data, int cur, int minPosSoFar )
{
    if(cur < data.length)
    {
        return (data[cur] < data[minPosSoFar]) ? 
            findMinPos(data, cur + 1, cur) :
            findMinPos(data, cur + 1, minPosSoFar);
    }

    return minPosSoFar;
}