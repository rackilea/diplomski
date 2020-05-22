public class MainActivity extends ActionBarActivity {

    Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text2;
        text2 = (TextView) findViewById(R.id.textView2);

        t = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateTextView();
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

    }

    public void run(View v) {
        t.start();
    }

    private void updateTextView() {
        TextView text2;
        double update;
        double rateofPay = 9.00;
        text2 = (TextView)findViewById(R.id.textView2);
        CharSequence newtime = text2.getText();
        double number = Double.parseDouble(newtime.toString());
        update = number+ rateofPay;
        text2.setText(String.valueOf(update));
    }

    //.........