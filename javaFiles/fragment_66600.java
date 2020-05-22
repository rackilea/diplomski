public Array slice(int left, int right)
{
    int length = right - left; // this is the proper length
    Array ob = new Array(length);
    for(int i = 0; i < length; i++)
        ob.a[i] = this.a[i + left];
    return ob;
}