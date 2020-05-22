private Handler mHandler = new Handler(Looper.getMainLooper()) {
    @Override
    public void handleMessage(Message msg) {
        synchronized (this) {
            BusProvider.get().post(msg.obj);
        }
    }
};

private void post(Object message) {
    Message msg = mHandler.obtainMessage(0);
    msg.obj = message;
    mHandler.sendMessage(msg);
}

@Override
public void failure(RetrofitError error) {
    this.post(new SignupTask.ErrorEvent(new String(((TypedByteArray) error.getResponse().getBody()).getBytes())));
}