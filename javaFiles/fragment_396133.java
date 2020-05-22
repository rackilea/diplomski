class BackgroundService extends Service {

  IBackgroundService.Stub binder = new IBackgroundService.Stub() {
    public void queueMsg(String phoneNo, String msgBody, String timeNew) {
      // enqueue message to service thread. Do not process msg in this method.
    }
  };

  public IBinder getBinder() {
    return binder;
  }
}