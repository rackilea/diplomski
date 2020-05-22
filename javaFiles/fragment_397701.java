swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
swipeLayout.setOnRefreshListener(this);

....

@Override public void onRefresh() {
    new Handler().postDelayed(new Runnable() {
        @Override public void run() {
            swipeLayout.setRefreshing(false);
        }
    }, 5000);
}