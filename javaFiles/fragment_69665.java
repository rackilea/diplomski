public void onLocationChanged(Location location) {
        Message msg = Message.obtain();
        msg.what = TYPE_LOCATION_CHANGED;
        msg.obj = location;
        mListenerHandler.sendMessage(msg);
    }