public class BaseActivity extends AppCompatActivity {
    private static Thread t = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (t != null) {
            try {
                if (t.isAlive()) {
                    t.interrupt();
                    t.join();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            t = null;
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        t = new Thread() {
            public void run() {
                try {
                    sleep(15 * 60 * 1000);
                     finishAffinity();
                    System.exit(0);
                } catch (InterruptedException e) {
                    return;
                }
            }
        };
        t.start();
    }
}