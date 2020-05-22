public static class Int32Extensions
{
    private static readonly object[] BoxedIntegers = CreateCache();

    private static object[] CreateCache()
    {
        object[] ret = new object[256];
        for (int i = -128; i < 128; i++)
        {
            ret[i + 128] = i;
        }
    }

    public object Box(this int i)
    {
        return (i >= -128 && i < 128) ? BoxedIntegers[i + 128] : (object) i;
    }
}