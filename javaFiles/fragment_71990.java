public class MainActivity extends Activity {
    private TextView mText;
    private EditText mUserInput;
    private CounterThread mCounterThread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        mText = (TextView) findViewById(R.id.text);
        mUserInput = (EditText) findViewById(R.id.userInput);
        mCounterThread = new CounterThread();
        mCounterThread.start();
    }

    @Override
    public synchronized void onPause() {
        super.onPause();
        mCounterThread.onPause();
    }

    @Override
    public synchronized void onResume() {
        super.onResume();
        mCounterThread.onResume();
    }

    public void startCounterThread() {
        mCounterThread.start();
    }

    public void button_handler(View v) {
        startCounterThread();
    }

    public void updateSeconds(final long seconds) {
        Runnable UIdoWork = new Runnable() {
            public void run() {
                String time = String.valueOf(seconds);
                mText.setText("Your file will open in " + time + " seconds");
            }
        };
        runOnUiThread(UIdoWork);
    }

    private class CounterThread extends Thread {
        private int count = 10;
        private final Object lock = new Object();
        private volatile boolean isRunning = true;

        public void onResume() {
            if(!isRunning){
                isRunning = true;
                synchronized (lock){
                    lock.notify();
                }
            }

        }

        public void onPause() {
            isRunning = false;
        }

        @Override
        public void run() {
            while (count != 0) {

                synchronized (lock) {

                    if (!isRunning) try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        //
                    }
                }


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //
                }
                updateSeconds(count--);
            }

        }
    }
}