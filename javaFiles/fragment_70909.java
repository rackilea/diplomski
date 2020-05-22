public void showAndHideDate(RecyclerView mRecyclerView, int firstVisibleItemPosition, int lastVisibleItemPosition){

    for (int i = firstVisibleItemPosition; i <= lastVisibleItemPosition; ++i) {
        final ThemMessageHolder holder = (ThemMessageHolder) mRecyclerView.findViewHolderForAdapterPosition(i);
        holder.mSentAtTextView.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                holder.mSentAtTextView.setVisibility(View.GONE);
            }
        },3500);
    }       

}