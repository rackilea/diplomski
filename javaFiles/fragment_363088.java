listView.setOnScrollListener(new OnScrollListener() {
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if ( scrollState == OnScrollListener.SCROLL_STATE_IDLE )
        {
          listView.invalidateViews();
        }

    }

    @Override
    public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {}
});