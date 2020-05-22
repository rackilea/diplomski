int[] merge(int[] a, int[] b)
{
    int[] out = new int[a.length + b.length]; //out array large enough for both contents
    int ac = 0; //a index counter
    int bc = 0; //b index counter
    int outc = 0; //out index counter

    //merge until one array is fully used up
    while(ac < a.length && bc < b.length)
        out[outc++] = a[ac] < b[bc] ? a[ac++] : b[bc++];

    //add the remaining elements to out
    while(ac < a.length)
        out[outc++] = a[ac++];
    while(bc < b.length)
        out[outc++] = b[bc++];

    //return the merged array
    return out;
}