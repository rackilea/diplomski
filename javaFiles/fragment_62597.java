public static void swapMin( int[] data, int cur )  
{   
    int min = findMinPos( data, cur, cur );

    int minValue = data[min];
    data[min] = data[cur];
    data[cur] = minValue;
}