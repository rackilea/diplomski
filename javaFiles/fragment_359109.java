protected void onDestroy() {
    if (DEBUG_LIFECYCLE) Slog.v(TAG, "onDestroy " + this);
    mCalled = true;

    // dismiss any dialogs we are managing.
    if (mManagedDialogs != null) {
        final int numDialogs = mManagedDialogs.size();
        for (int i = 0; i < numDialogs; i++) {
            final ManagedDialog md = mManagedDialogs.valueAt(i);
            if (md.mDialog.isShowing()) {
                md.mDialog.dismiss();
            }
        }
        mManagedDialogs = null;
    }

    // close any cursors we are managing.
    synchronized (mManagedCursors) {
        int numCursors = mManagedCursors.size();
        for (int i = 0; i < numCursors; i++) {
            ManagedCursor c = mManagedCursors.get(i);
            if (c != null) {
                c.mCursor.close();
            }
        }
        mManagedCursors.clear();
    }

    // Close any open search dialog
    if (mSearchManager != null) {
        mSearchManager.stopSearch();
    }

    getApplication().dispatchActivityDestroyed(this);
}