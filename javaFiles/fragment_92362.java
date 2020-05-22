public void onItemCountChanged(int totalItemCount) {
    final int visibleItemCount = mList.getChildCount();

    ....

    updateLongList(visibleItemCount, totalItemCount);
}