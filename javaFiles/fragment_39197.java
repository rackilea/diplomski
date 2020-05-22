public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
    int viewType = viewHolder.getItemViewType();

    if (viewType == MY_FIRST_TYPE) {
        ((MyFirstSubclass) viewHolder).foo();
        // ...
    } else if (viewType == MY_SECOND_TYPE) {
        ((MySecondSubclass) viewHolder).bar();
        // ...
    }

    // ...
}