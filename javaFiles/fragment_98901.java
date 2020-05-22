static int dyn(int maxItems, int maxSize)
{
    if(maxItems < 0)
    {
        return 0;
    }

    if( itemArray[maxItems].s > maxSize)
    {
        return dyn(maxItems-1,maxSize);
    }
    else
    {
        int result =  Math.max(dyn(maxItems-1, maxSize), dyn(maxItems-1, maxSize - itemArray[maxItems].s) + itemArray[maxItems].v);
        tab[maxItems][maxSize] = result;
        return result;
    }
}