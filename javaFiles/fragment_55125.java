public class CommonForApp extends Application {

    private static CommonForApp sInstance;
    …

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        …
    }

    public static CommonForApp getInstance() {
        return sInstance;
    }
}