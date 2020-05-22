... ...

// If the app is Honeycomb MR1 or earlier, switch its AsyncTask
// implementation to use the pool executor.  Normally, we use the
// serialized executor as the default. This has to happen in the
// main thread so the main looper is set right.
if (data.appInfo.targetSdkVersion <= android.os.Build.VERSION_CODES.HONEYCOMB_MR1) {
    AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
}

... ...