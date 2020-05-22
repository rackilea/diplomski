@Override
public void onScrollStateChanged(AbsListView view, int scrollState) {
}

@Override
public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            swiperefresh.setEnabled(firstVisibleItem == 0);
}