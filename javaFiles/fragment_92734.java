public static boolean scroll_is_idle = true;

mListView.setOnScrollListener(new OnScrollListener() {
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) { }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
                case OnScrollListener.SCROLL_STATE_IDLE:
                    scroll_is_idle = true;
                    mAdapter.notifyDataSetChanged();
                    break;
                case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL: 
                    scroll_is_idle = false;
                    break;
                case OnScrollListener.SCROLL_STATE_FLING:
                    scroll_is_idle = false;
                    break;
        }
    }
});