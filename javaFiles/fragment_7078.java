@Override
    public void onBackPressed() {
        if (swipeRefreshLayout.isRefreshing()){
           //  swipeRefreshLayout is Refreshing
        }else {
           //  swipeRefreshLayout is not Refreshing call super.onBackPressed();
           super.onBackPressed();
        }
    }