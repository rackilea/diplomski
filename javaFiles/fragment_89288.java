public static <T extends Cloneable> List<T> repeat(List<T> in, int times)
{
    List<T> results = new ArrayList<>();
    for (T x : in)
    {
        for (int i = 0; i < times; ++i)
            results.add(x);
    }
    return results;
}