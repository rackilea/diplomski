private void showNextSnackbarLocked() {
    if (mNextSnackbar != null) {
        mCurrentSnackbar = mNextSnackbar;
        mNextSnackbar = null;

        final Callback callback = mCurrentSnackbar.callback.get();
        if (callback != null) {
            callback.show();
        } else {
            // The callback doesn't exist any more, clear out the Snackbar
            mCurrentSnackbar = null;
        }
    }
}