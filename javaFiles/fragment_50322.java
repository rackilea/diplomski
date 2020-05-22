private static final Handler sHandler;
private static final int MSG_SHOW = 0;
private static final int MSG_DISMISS = 1;

static {
    sHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case MSG_SHOW:
                    ((Snackbar) message.obj).showView();
                    return true;
                case MSG_DISMISS:
                    ((Snackbar) message.obj).hideView(message.arg1);
                    return true;
            }
            return false;
        }
    });
}