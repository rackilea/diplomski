private void initExecutorHelper() {
    if (LOG_DEBUG) Log.d(TAG, "initExecutorHelper: ");
    if (mExecutorHelper == null) {
        mExecutorHelper = ThreadPoolExecutorHelper.getInstance();
    }
}