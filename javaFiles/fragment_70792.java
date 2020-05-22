private List<Entry> entries;
    private OnAdapterClick clickListener;

    EntryAdapter(List<Entry> entries, OnAdapterClick  clickListener)
    {
        this.entries = entries;
        this.clickListener = clickListener;
    }