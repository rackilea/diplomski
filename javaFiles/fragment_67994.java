public WrappedItem[] processItems(Item[] items)
{
    WrappedItem[] wrappedItems = WrappedItem[items.length];
    int i = 0;
    for (Item item : items)
    {
        /* …do something with the item… */
        wrappedItems[i++] = item;
    }
    return wrappedItems;
}