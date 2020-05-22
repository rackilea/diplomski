private final SnackbarManager.Callback mManagerCallback = new SnackbarManager.Callback() {
    @Override
    public void show() {
        sHandler.sendMessage(sHandler.obtainMessage(MSG_SHOW, Snackbar.this));
    }

    @Override
    public void dismiss(int event) {
        sHandler.sendMessage(sHandler.obtainMessage(MSG_DISMISS, event, 0, Snackbar.this));
    }
};