int[] copyOfRange (int[] src, int start, int end) {
    int len = end - start;
    int[] dest = new int[len];
    // note i is always from 0
    for (int i = 0; i < len; i++)
    {
        dest[i] = src[start + i]; // so 0..n = 0+x..n+x
    }
    return dest;
}