recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
@Override
public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    super.onScrolled(recyclerView, dx, dy);
    totalItemCount = llm.getItemCount();
    lastVisibleItem = llm.findLastVisibleItemPosition();
    if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
        isLoading = true;
        myList.add(new myObject(TYPE_BOTTOM_LOADING));
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                mAdapter.notifyItemInserted(myList.size() - 1);
            }
        });
        startIndex += INDEX_INTERVAL;
        endIndex += INDEX_INTERVAL;
        getMyList(startIndex, endIndex);
    }
}});