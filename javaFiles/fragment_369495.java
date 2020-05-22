public class SecondClass extends Activity {
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyboard);
        textView = (TextView) findViewById(R.id.something);
        random_Method('A');
    }

    public void random_Method(char NewChar) {

    }