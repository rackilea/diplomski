public static <T> int linearSearch(final T[] data, final T value)
{
    final int index;

    if(data == null)
    {
        index = -1;
    }
    else
    {
        final List<T> list;

        list  = Arrays.asList(data);
        index = list.indexOf(value);
    }

    return (index);
}