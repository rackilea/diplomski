public class MainActivity extends ActionBarActivity {

    TextView text2;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text2 = (TextView) findViewById(R.id.textView2);

        handler = new Handler();

    }

    Runnable updateText = new Runnable(){
        @Override
        public void run(){
            updateTextView();
            handler.postDelayed(this, 1000);
        }
    };

    public void run(View v) {
        handler.postDelayed(updateText, 1000);
    }

    private void updateTextView() {

        double update;
        double rateofPay = 9.00;
        CharSequence newtime = text2.getText();
        double number = Double.parseDouble(newtime.toString());
        update = number+ rateofPay;
        text2.setText(String.valueOf(update));
    }

    //.............