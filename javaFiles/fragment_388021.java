public void insert() {
        if (LOG_DEBUG) Log.d(TAG, "requestQREntityList: whatKind= " + whatKind);
        mExecutorHelper.submitRunnable(() -> {
        if (!Thread.interrupted()) {
        //request a list or inset something, write your logic.

        } else {
        if (LOG_DEBUG) Log.e(TAG, "run: Thread is interrupted");
        }
        });
        }