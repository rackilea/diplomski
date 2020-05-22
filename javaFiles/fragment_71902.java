public class DrawView extends View implements OnTouchListener{
    private Timer timer = new Timer();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(Bundle savedInstanceState);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                handler.sendEmptyMessage();
            }
        }, 0, 2000);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            newgame();
        }
    };
}