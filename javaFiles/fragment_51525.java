public void onScrollStateChanged(AbsListView view, int scrollState) {
int count=g_count; \\you dont really need to declare this, just use g_count
int threshold = 1;
int counter = mListView.getCount();

if (scrollState == SCROLL_STATE_IDLE) {

if (mListView.getLastVisiblePosition() >= counter - threshold) {
    updateData();                   
}
}