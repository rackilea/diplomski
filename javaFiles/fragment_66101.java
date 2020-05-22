private static <T> T get(@Nonnull final Iterable<T> iterable, final int index, @Nonnull final T missing)
{
    if (index < 0) { return missing; }
    if (iterable instanceof List) 
    {
        final List<T> l = List.class.cast(iterable);
        return l.size() <= index ? l.get(index) : missing;
    }
    else
    {
        final Iterator<T> iterator = iterable.iterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            final T o = iterator.next();
            if (i == index) { return o; }
        }
        return missing;
    }
}