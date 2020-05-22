public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();

        // Install the cache
        try {
           File httpCacheDir = new File(this.getCacheDir(), "http");
           long httpCacheSize = 10 * 1024 * 1024; // 10 MiB
           HttpResponseCache.install(httpCacheDir, httpCacheSize);
        catch (IOException e) {
           Log.i(TAG, "HTTP response cache installation failed:" + e);
        }

        // Register for activity lifecycle callbacks, 
        // specifically interested in activity stop callbacks.
        registerActivityLifecycleCallbacks(
           new MyApplicationActivityLifeCycleCallbacks());
    }

    // method to flush cache contents to the filesystem
    public void flushCache() {
        HttpResponseCache cache = HttpResponseCache.getInstalled();
        if (cache != null) {
            cache.flush();
        }
    }

    private class MyApplicationActivityLifeCycleCallbacks extends ActivityLifecycleCallbacks {
        public void onActivityStopped (Activity activity) {
            flushCache();
        }

        // other methods
    }  
}