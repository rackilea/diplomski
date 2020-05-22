public void show(int duration, Callback callback) {
    synchronized (mLock) {
        if (isCurrentSnackbarLocked(callback)) {
            // Means that the callback is already in the queue. We'll just update the duration
            mCurrentSnackbar.duration = duration;

            // If this is the Snackbar currently being shown, call re-schedule it's
            // timeout
            mHandler.removeCallbacksAndMessages(mCurrentSnackbar);
            scheduleTimeoutLocked(mCurrentSnackbar);
            return;
        } else if (isNextSnackbarLocked(callback)) {
            // We'll just update the duration
            mNextSnackbar.duration = duration;
        } else {
            // Else, we need to create a new record and queue it
            mNextSnackbar = new SnackbarRecord(duration, callback);
        }

        if (mCurrentSnackbar != null && cancelSnackbarLocked(mCurrentSnackbar,
                Snackbar.Callback.DISMISS_EVENT_CONSECUTIVE)) {
            // If we currently have a Snackbar, try and cancel it and wait in line
            return;
        } else {
            // Clear out the current snackbar
            mCurrentSnackbar = null;
            // Otherwise, just show it now
            showNextSnackbarLocked();
        }
    }
}