@Override
protected void onLoadingStateChanged(@NonNull LoadingState state) {
    switch (state) {
        case LOADING_INITIAL:
            homeRecyclerViewProgressBar.setVisibility(View.VISIBLE);
            break;
        case LOADING_MORE:
        case LOADED:
            homeRecyclerViewProgressBar.setVisibility(View.GONE);
            break;
        case FINISHED:
            homeRecyclerViewProgressBar.setVisibility(View.GONE);
            break;
        case ERROR:
            retry();
            break;
    }
}