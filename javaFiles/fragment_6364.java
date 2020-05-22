public class Main2Activity extends AppCompatActivity {

    private MyWorkerThread mWorkerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mWorkerThread = new MyWorkerThread("myWorkerThread");
        final Runnable task = new Runnable() {
            @Override
            public void run() {
                Log.d("TAG", "Done.");
                mWorkerThread.postTask(this);
            }
        };
        mWorkerThread.start();
        mWorkerThread.prepareHandler();
        mWorkerThread.postTask(task);
    }

    @Override
    protected void onDestroy() {
        mWorkerThread.quit();
        super.onDestroy();
    }
}

class MyWorkerThread extends HandlerThread {

    private Handler mWorkerHandler;

    public MyWorkerThread(String name) {
        super(name);
    }

    public void postTask(Runnable task){
        mWorkerHandler.postDelayed(task, 1000); // set timeout which needed
    }

    public void prepareHandler(){
        mWorkerHandler = new Handler(getLooper());
    }
}