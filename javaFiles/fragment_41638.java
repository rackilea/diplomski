public static <T> void removeReference(List<WeakReference<T>> list,
                                       T reference)
{
    for (Iterator<WeakReference<T>> iterator = list.iterator();
         iterator.hasNext(); )
    {
        WeakReference<T> weakRef = iterator.next();
        if (weakRef.get() == reference)
        {
            iterator.remove();
        }
    }
}