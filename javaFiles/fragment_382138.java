private boolean editMode = true;
private float[] ultimoToque = new float[2];
private RelativeLayout myView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_graph_maker);

    myView = findViewById(R.id.graph_space);
    myView.setOnTouchListener(touchListener);
}