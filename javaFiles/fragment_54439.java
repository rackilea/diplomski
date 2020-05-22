@Override
    public void onStart() {
        Log.e(TAG, "onStart");
        mView.showProgress();
        request(Long.MAX_VALUE);
    }