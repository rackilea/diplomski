// TASK
public class YourTimerTask extends TimerTask {
    private Handler _Handler;

    public YourTimerTask(Handler handler) {
        _Handler = handler;
    }

    public void run() {
        _Handler.sendEmptyMessage(0);
    }
}

// TASK HANDLER (private property in your acitivity)
private Handler _taskHandler = new Handler(){
    public void dispatchMessage(android.os.Message msg) {
        // do cleanup, close db cursors, file handler, etc.
        // start your target activity
        Intent viewTargetActivity = new Intent(YourCurrentActivity.this, YourTargetActivity.class);

    };
};


// IN YOUR ACTIVITY (for isntance, in onResume method)
Timer timer = new Timer();
timer.schedule(new YourTimerTask(_taskHandler), seconds*1000);