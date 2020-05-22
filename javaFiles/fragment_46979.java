protected void shake() {
    if(mAllowShake) {
        mAllowShake = false;

        // do shake

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                mAllowShake = true;
            }
        };

        handler.sendMessageDelayed(null, 500);  // time in milliseconds
    }
}