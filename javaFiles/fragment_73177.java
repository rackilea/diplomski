public class MainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "in.manas.anurag.firstapp.MESSAGE";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View touchView = findViewById(R.id.touchView);
        textView = (TextView)findViewById(R.id.textView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
            textView.setText("Touch coordinates : " +
            String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
            return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}