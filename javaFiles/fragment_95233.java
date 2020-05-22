public class MainActivity extends Activity {

    public static final int UPDATE = 1;
    public static final int WORK = 2;

    private Handler uiHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case UPDATE:
                // Perform UI updates here
                ....
                // UI Updates done, schedule WORK in 30 seconds:
                this.sendMessageDelayed(this.obtainMessage(WORK), 30000);
                break;
            case WORK:
                new Thread(doWork).start();
                break;

            default:
                super.handleMessage(msg);
            }
        }

    };

private WeakReference<Handler> handlerRef = new WeakReference<Handler>( uiHandler );

    private Runnable doWork = new Runnable() {

        @Override
        public void run() {
            // This will run on a different thread.

            // If UI is still around, tell it to update
            Handler ui = handlerRef.get();
            if( ui != null )
                ui.sendEmptyMessage(MainActivity.UPDATE);
        }
    };  

    @Override
    protected void onPause() {
        uiHandler.removeMessages(WORK);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Resume UI updates in 500ms, allowing UI to settle
        uiHandler.sendMessageDelayed(uiHandler.obtainMessage(WORK), 500);
    }

    ....
}