public final class ThreadPool {
    private static Handler sUiThreadHandler;

    private ThreadPool() {
    }

    /**
     * Run the {@code Runnable} on the UI main thread.
     *
     * @param runnable the runnable
     */
    public static void runOnUiThread(Runnable runnable) {
        if (sUiThreadHandler == null) {
            sUiThreadHandler = new Handler(Looper.getMainLooper());
        }
        sUiThreadHandler.post(runnable);
    }

    // Other, unrelated methods...
}