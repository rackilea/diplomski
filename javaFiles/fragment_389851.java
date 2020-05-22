public class ShipInfoManager {
    public interface MyCallback {
        void callbackCall();
    }

    public void setCustomEventListener(MyCallback eventListener) {
       callback = eventListener;
    }

    Context mContext;

    public ShipInfoManager(Context _mContext)  {
        this.mContext = _mContext;

        reloadData();
        startTimer();
    }

    MyCallback callback;

    void onEvent() {
        // Check if we have listeners 
        if (callback != null)
            callback.callbackCall();
    }

    private void startTimer() {
         /* RUN EVERY MIN */
        final Handler handler = new Handler();
        Timer timer = new Timer();
        TimerTask doAsynchronousTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @SuppressWarnings("unchecked")
                    public void run() {
                        try {
                            reloadData();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };
        // TEMP SUSPEND FROM PREVENTING RELOAD //
        timer.schedule(doAsynchronousTask, 0, 5000);

    }

    /* JSON handling and extraction */
    private void reloadData() {
        //Do sth to reload the data

        //After reload, I want to fire the callback
        onEvent();

    }
}