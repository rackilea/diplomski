public static int getDeepLength(Object array)
{
    int count = 0;

    if(array instanceof int[])
        count += ((int[])array).length;

    if(array instanceof Object[])
        for(Object current : (Object[])array)
            count += getNestedCount(current);

    return count;
}

static int getNestedCount(Object obj)
{
    if (obj instanceof Object[] )
       return getDeepLength((Object[])obj);

    if (obj instanceof int[] )
        return ((int[])obj).length;

    return 1;
}