private Context context;
private Handler backgroundHandler;
private Handler uiHandler;

public MyClass(Context context, Handler handler) {
  this.context = context;
  // this.activity = (Activity) context;
  this.uiHandler = handler;

  HandlerThread handlerThread = new HandlerThread("MyClass.Handler");
  handlerThread.start();
  backgroundHandler = new Handler(handlerThread.getLooper());
}

public void MyFunction() {
    uiHandler.post(new Runnable() {
        public void run() {

          // Code to execute on ui thread

            backgroundHandler.post(new Runnable() {
                public void run() {
                  // Code to execute on bg thread
                }
            });           
        }
    });
}