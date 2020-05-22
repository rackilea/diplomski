@Override
    protected void onStartLoading() {
        super.onStartLoading();
            if(mMoviesCollection.isEmpty()){
                forceLoad();
                progressBar.setVisibility(View.VISIBLE);
                errorTextView.setVisibility(View.INVISIBLE);
            } else {
                deliverResult(mMoviesCollection)
            }
    }