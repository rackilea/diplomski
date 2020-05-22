void addEntry(int paramInt1, K paramK, V paramV, int paramInt2)
{
    if ((size >= threshold) && (null != table[paramInt2]))
    {
        resize(2 * table.length);
        paramInt1 = null != paramK ? hash(paramK) : 0;
        paramInt2 = indexFor(paramInt1, table.length);
    }
    createEntry(paramInt1, paramK, paramV, paramInt2);
}