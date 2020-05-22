public class StorageManager
{
    private static StorageManager sInstance;
    private String mSomeData;

    public static StorageManager getInstance()
    {
        if (sInstance == null) {
            sInstance = new StorageManager();
        }

        return sInstance;
    }

    private StorageManager()
    {

    }

    public String getData()
    {
        return mSomeData;
    }

    public void setData(String data)
    {
        mSomeData = data;
    }
}