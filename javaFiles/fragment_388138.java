public class SplashActivity extends Activity  {
   private long splashDelay = 5000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        TimerTask task = new TimerTask()
        {

            @Override
            public void run() {
                finish();
                Intent mainIntent = new Intent().setClass(EJ_Splash.this, EJ_Board.class);
                startActivity(mainIntent);

            }

        };

        Timer timer = new Timer();
        timer.schedule(task, splashDelay);

    }
}