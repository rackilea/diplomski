private void sendMsg(boolean delayed) {
    if(mNotificationSoundHandler == null) {
        mNotificationSoundHandler = new Handler(Looper.getMainLooper()) {

            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.d(TAG, " !!!Handle Message !!!");
                updateSoundLocked();
            }
        };
    }
}