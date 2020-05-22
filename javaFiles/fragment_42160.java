public class MyApplication extends Application {
    private static MyApplication mInstance;

    @Override
    protected void onCreate() {
        super.onCreate();
        mInstance = this;
        // create your Singleton!
        Singleton.getInstance();
    }

    public static MyApplication getInstance() {
        return mInstance;
    }
}