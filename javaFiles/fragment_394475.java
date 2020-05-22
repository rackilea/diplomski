public class MainActivity extends Activity implements OnClickListener {
    Button mybutton;
    TextView tvView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        mybutton = (Button) findViewById(R.id.myactualbutton);
        tvView = (TextView) findViewById(R.id.produceText1);
        mybutton.setOnClickListener(this);
    }

    public void onClick(View v) {
        addiTion(v);
    }

    public void addiTion(View v){
        tvView.setText("fgdsgdfhgdfh");
    }
}