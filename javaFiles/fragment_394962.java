public class MyActivity extends Activity
{
    TextView tv1, tv2, etc...;

    public void onCreate(...)
    {
        super.onCreate(...);
        setContentView(R.layout.my_layout);
        tv1 = (TextView) findViewById(R.id.textView1);
        ...
     }