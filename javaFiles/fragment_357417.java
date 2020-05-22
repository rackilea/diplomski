static Counter counter;

public static Counter count(Object parent) 
{
    counter = new Counter();
    count2(parent);
    return counter;
}

private static void count2(Object parent) 
{
    Object cur = new Object(parent);

    if(cur.isChild())
        Counter.child++;
    else if(cur.isParent())
    {
        counter.parent++;
        count2(cur);
    }
}