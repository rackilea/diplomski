public TextView info;  //<<< declare here...
public int l = 0;
GLSurfaceView ourSurface;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.cad);
    info = (TextView) findViewById(R.id.info);  //<<< initialize here...
    ......