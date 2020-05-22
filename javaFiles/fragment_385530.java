public class ButtonActivity extends Activity {

Button mbutt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mbutt = (Button)findViewById(R.id.Button_Click);
    }