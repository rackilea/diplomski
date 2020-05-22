public class SplashActivity extends Activity implements Runnable {

    Thread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splashScreen);
        mThread = new Thread(this);

        mThread.start();
    }

    @Override
    public void run(){
        try {
            Thread.sleep(8000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));

            finish();
        }
    }
}