public class MainActivity extends AppCompatActivity {

    private TextView           textView;
    private TestOfPassUIThread t;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        textView = (TextView)findViewById (R.id.textView);

        t = new TestOfPassUIThread (this) {

            @Override
            public void fillTextView (float xAxis) {
                textView.setText ("Current xAxis: " + xAxis);
            }
        };
    }

    @Override
    protected void onResume () {
        super.onResume ();
        t.register ();
    }

    @Override
    protected void onPause () {
        t.unregister ();
        super.onPause ();
    }
}