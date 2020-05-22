/**
     * Logs an amount of bytes loaded in an amount of seconds
     *
     * @param bytes amount of bytes loaded
     * @param seconds time in seconds that it took to load those bytes
     */
    private void logBytesLoadedInSeconds(long bytes, float seconds){
        mBytesLoaded += bytes;
        mBytesLoadedSeconds += seconds;
        if(mBytesLoadedSeconds > 0){
            double bytesPerSecond = mBytesLoaded / mBytesLoadedSeconds;
            double bitsPerSecond = bytesPerSecond * 8; // (8 bits in a byte)
            if(bitsPerSecond < mIndicatedBitrate){
                // buffer is falling behind!
                mBufferWarned = true;
            }else{
                if(mBufferWarned){
                    // buffer caught up
                }
            }
        }
    }