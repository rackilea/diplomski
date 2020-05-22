@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    container = (FrameLayout) findViewById(R.id.container);
    //set Fragment to activity
    BlankFragment frag = new BlankFragment();
   getFragmentManager().beginTransaction().add(R.id.container,frag).commit();
}