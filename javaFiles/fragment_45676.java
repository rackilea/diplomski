public class MainActivity extends Activity {

    private ImageView leftImageButton;
    private boolean leftButtonDown = false;
    private ImageView knight;
    private AsyncTask asyncTask = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftImageButton = (ImageView) findViewById(R.id.imageView2);
        knight = (ImageView) findViewById(R.id.imageView1);
        leftImageButton.setOnTouchListener(new LeftImageListener());
    }

    public void startTask() {
        asyncTask = new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                if (leftButtonDown) {
                    while (leftButtonDown) {
                        try {
                            Thread.sleep(10);
                            runOnUiThread(new Runnable() {

                                @Override
                                public void run() {
                                    try {
                                        moveLeft(5);

                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }

                                }
                            });

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                return null;
            }

        }.execute();
    }

    public void moveLeft(int speed) throws InterruptedException {
        knight.setLeft(knight.getLeft() - speed);
    }

    public class LeftImageListener implements OnTouchListener {

        public LeftImageListener() {
            // TODO Auto-generated constructor stub
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                leftButtonDown = true;
                startTask();
                break;
            case MotionEvent.ACTION_UP:
                leftButtonDown = false;
                break;
            default:
                break;
            }

            return true;
        }

    }

}