class CustomAdapterViewTypedImpl extends LinearLayout {

    private Adapter adapter;
    private SparseArray<List<View>> typedViewsCache = new SparseArray<List<View>>();
    private final DataSetObserver observer = new DataSetObserver() {

        @Override
        public void onChanged() {
            refreshViewsFromAdapter();
        }

        @Override
        public void onInvalidated() {
            removeAllViews();
        }
    };

    public CustomAdapterViewTypedImpl(Context context) {
        super(context);
    }

    public CustomAdapterViewTypedImpl(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomAdapterViewTypedImpl(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public Adapter getAdapter() {
        return adapter;
    }

    public void setAdapter(Adapter adapter) {
        if (this.adapter != null) {
            this.adapter.unregisterDataSetObserver(observer);
        }
        this.adapter = adapter;
        if (this.adapter != null) {
            this.adapter.registerDataSetObserver(observer);
        }
        initViewsFromAdapter();
    }

    protected void initViewsFromAdapter() {
        typedViewsCache.clear();
        removeAllViews();
        View view;
        if (adapter != null) {
            for (int i = 0; i < adapter.getCount(); i++) {
                view = adapter.getView(i, null, this);
                addToTypesMap(adapter.getItemViewType(i), view, typedViewsCache);
                addView(view, i);
            }
        }
    }

    protected void refreshViewsFromAdapter() {
        SparseArray<List<View>> typedViewsCacheCopy = typedViewsCache;
        typedViewsCache = new SparseArray<List<View>>();
        removeAllViews();
        View convertView;
        int type;
        for (int i = 0; i < adapter.getCount(); i++) {
            type = adapter.getItemViewType(i);
            convertView = shiftCachedViewOfType(type, typedViewsCacheCopy);
            convertView = adapter.getView(i, convertView, this);
            addToTypesMap(type, convertView, typedViewsCache);
            addView(convertView, i);
        }
    }

    private static void addToTypesMap(int type, View view, SparseArray<List<View>> typedViewsCache) {
        List<View> singleTypeViews = typedViewsCache.get(type);
        if(singleTypeViews == null) {
            singleTypeViews = new ArrayList<View>();
            typedViewsCache.put(type, singleTypeViews);
        }
        singleTypeViews.add(view);
    }

    private static View shiftCachedViewOfType(int type, SparseArray<List<View>> typedViewsCache) {
        List<View> singleTypeViews = typedViewsCache.get(type);
        if(singleTypeViews != null) {
            if(singleTypeViews.size() > 0) {
                return singleTypeViews.remove(0);
            }
        }
        return null;
    }
}