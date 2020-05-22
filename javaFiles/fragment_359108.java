protected void onPause() {
    if (DEBUG_LIFECYCLE) Slog.v(TAG, "onPause " + this);

    // This is to invoke 
    // Application.ActivityLifecyleCallbacks.onActivityPaused(Activity)
    getApplication().dispatchActivityPaused(this);

    // The flag to enforce calling of this method
    mCalled = true;
}