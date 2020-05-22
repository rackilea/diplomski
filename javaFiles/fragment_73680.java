public int getObservedBitrate(){
        if(mBytesLoadedSeconds != 0){
            double bytesPerSecond = mBytesLoaded / mBytesLoadedSeconds;
            double bitsPerSecond = bytesPerSecond * 8; // (8 bits in a byte)
            Log.d(TAG," mBytesLoaded " + mBytesLoaded + " in "+mBytesLoadedSeconds+" seconds ("+(int)bitsPerSecond+" b/s indicated "+mIndicatedBitrate+" b/s) ");
            return (int)bitsPerSecond;
        }
        return 0;
    }