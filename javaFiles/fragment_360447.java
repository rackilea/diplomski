public class MyThread extends Thread {
    private Handler mHandler;

    public void run() {
        Looper.prepare();
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    // manage the message
                }
            }
        };
        Looper.loop();
    }

    public void stopLooper() {
        if (Looper.myLooper()!=null)
            Looper.myLooper().quitSafely();
    }
}