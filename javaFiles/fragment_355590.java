public void getArr(CP[] c,String t)
{
    if (c.length != 3) {
        throw new IllegalArgumentException("Required exactly 3 array elements");
    }
    for(int i=0;i<c.length;i++)
    {
        cp[nr]=c[nr];
        nr++;
    }
}