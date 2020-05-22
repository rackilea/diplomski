private RecyclerView list;

private adapter recyclerAdapter;

private LinearLayoutManager layoutManager;

private int visibleItemCount, totalItemCount, firstVisibleItemPosition, lastVisibleItem;
private int oldFirstVisibleItemPos = -1, oldLastVisibleItemPos = -1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recycler_view5);
    recView = (RecyclerView) findViewById(R.id.list);

    layoutManager = new LinearLayoutManager(this);
    recView.setLayoutManager(layoutManager);
    recyclerAdapter = new adapter(RecyclerViewActivity5.this, country);
    recView.setAdapter(recyclerAdapter);
    recView.addOnScrollListener(onScrollListener);

    firstVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
    lastVisibleItem = layoutManager.findLastCompletelyVisibleItemPosition();
    updateVisibleItem();
}

private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }
    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        visibleItemCount = layoutManager.getChildCount();
        totalItemCount = layoutManager.getItemCount();
        firstVisibleItemPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
        lastVisibleItem = firstVisibleItemPosition +visibleItemCount;
        Toast.makeText(RecyclerViewActivity5.this, "Visible Item Total:"+String.valueOf(visibleItemCount), Toast.LENGTH_SHORT).show();

        updateVisibleItem();
    }
};

private void updateVisibleItem() {
    if(oldFirstVisibleItemPos == -1 && lastVisibleItem == -1) {
        oldFirstVisibleItemPos = firstVisibleItemPosition;
        oldLastVisibleItemPos = lastVisibleItem;
    } else if(firstVisibleItemPosition < oldFirstVisibleItemPos){

        if(lastVisibleItem < oldFirstVisibleItemPos)
            oldLastVisibleItemPos = lastVisibleItem;
        else
            oldLastVisibleItemPos = oldFirstVisibleItemPos -1;

        oldFirstVisibleItemPos = firstVisibleItemPosition;
    } else {
        if(firstVisibleItemPosition > oldLastVisibleItemPos)
            oldFirstVisibleItemPos = firstVisibleItemPosition;
        else
            oldFirstVisibleItemPos = oldLastVisibleItemPos + 1;
        oldLastVisibleItemPos = lastVisibleItem;
    }

    for(int i = oldFirstVisibleItemPos; i <= oldLastVisibleItemPos; i++) {
        Model model = list.get(i);
        model.setCount(model.getCount() + 1);
    }
}