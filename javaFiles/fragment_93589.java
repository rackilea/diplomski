public class TextFragment2 extends Activity implements OnClickListener {
    TextView text,add;
    private ImageView img;
    Button b;
    int value;
    String mobile,txt;
    File photo;
    private static final int CAMERA_REQUEST = 1888; 
    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_fragment);

        add= (TextView)findViewById(R.id.address);
        img= (ImageView)findViewById(R.id.img);

        b= (Button)findViewById(R.id.b);

        img.setOnClickListener(this);
        b.setOnClickListener(this);
        Bundle bundle= getIntent().getExtras();
        txt= bundle.getString("message");
        add.setText(txt);

    }