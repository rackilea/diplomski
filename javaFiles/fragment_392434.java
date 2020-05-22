private int getItemPositionByAdapterId(final long id)
{
    for (int i = 0; i < adapter.getCount(); i++)
    {
        if (adapter.getItemId(i) == id)
            return i;
    }
    return -1;
}