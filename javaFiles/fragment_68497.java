public class DisplayMessageActivity extends Activity {
TextView mTextview;
@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display_message);
    Intent intent = getIntent();
    String lol = intent.getStringExtra("lol");
    int lol1 = intent.getIntExtra("lol1",1);
    mTextview = (TextView) findViewById(R.id.textView1);
    mTextview.setText(lol+"@"+lol1);


}