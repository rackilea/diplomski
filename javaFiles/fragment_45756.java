static final Object sDataLock = new Object();
Serializer mSerializer;

class AsyncSave implements Runnable
{
    Object mSerialize;
    File mStorage;

    public AsyncSave(Object serialize, File storage)
    {
        mSerialize = serialize;
        mStorage = storage;
    }

    @Override
    public void run()
    {
        try {
            synchronized (sDataLock) {
                // write
                mSerializer.write(mSerialize, mStorage);
            }
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }       
}