private static boolean isTraceEnabled()
{
    return TRACE_LEVEL <= LOG_LEVEL;
}

private static void trace(String msg)
{
    if (isTraceEnabled())
    {
        System.out.println(msg);
    }
}

private static void foo()
{
    for (int i = 0; i < 10; i++)
    {
        doSomething();
        if (isTraceEnabled())
        {
            trace("FLOW-1: " + getHugeString() + " for i:" + i);
        }
    }
}