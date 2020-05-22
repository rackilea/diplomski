@Override
    protected void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        mTask = new LoadTask();
        if (DEBUG) Slog.v(TAG, "Preparing load: mTask=" + mTask);
        executePendingTask();
    }