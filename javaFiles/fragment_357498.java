public void removeLayoutComponent (Component component)
{
    // Remove the component
    ListIterator iterator = list.listIterator(0);

    while (iterator.hasNext())
    {
        Entry entry = (Entry) iterator.next();

        if (entry.component == component)
            iterator.remove();
    }

    // Indicate that the cell sizes are not known since
    dirty = true;
}