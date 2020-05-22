@Override
public void onActionModeStarted(ActionMode mode) {
    super.onActionModeStarted(mode);
    mActionMode = mode;
}

@Override
public void onActionModeFinished(ActionMode mode) {
    super.onActionModeFinished(mode);
    mActionMode = null;
}

@Override
public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
    mActionModeCallback = callback;
    return super.onWindowStartingActionMode(callback);
}