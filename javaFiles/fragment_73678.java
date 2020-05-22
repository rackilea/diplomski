private long mBytesLoaded = 0;
    private long mBytesLoadedSeconds = 0;
    private long mLastBytesLoadedTime = 0;

    @Override
    public void onLoadStarted(int sourceId, long length, int type, int trigger, Format format, int mediaStartTimeMs, int mediaEndTimeMs) {
        Log.d(TAG, "onLoadStarted sourceId " + sourceId + " length " + length + " type " + type + " format " + format + " mediaStartTimeMs " + mediaStartTimeMs + " mediaEndTimeMs " + mediaEndTimeMs);
        if(mLastBytesLoadedTime == 0) mLastBytesLoadedTime = System.currentTimeMillis();
    }

    @Override
    public void onLoadCompleted(int sourceId, long bytesLoaded, int type, int trigger, Format format, int mediaStartTimeMs, int mediaEndTimeMs, long elapsedRealtimeMs, long loadDurationMs) {
        Log.d(TAG, "onLoadCompleted sourceId " + sourceId + " bytesLoaded " + bytesLoaded + " type " + type + " format " + format + " mediaStartTimeMs " + mediaStartTimeMs + " mediaEndTimeMs " + mediaEndTimeMs);

        // log... logBytesLoadedInSeconds
        long now = System.currentTimeMillis();
        float diffInSeconds = (now - mLastBytesLoadedTime) / 1000;
        this.logBytesLoadedInSeconds(bytesLoaded, diffInSeconds); // helper function, explain bellow
        mLastBytesLoadedTime = now;
    }