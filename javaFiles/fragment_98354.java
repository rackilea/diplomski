static final String[] MOBILE_OS1 = new String[] { 
    "Android", "iOS", "Windows", "Blackberry"};
static final String[] MOBILE_OS2 = new String[] { 
    "Android", "iOS", "Windows"};

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.gridviewlayout);
    GridView gridView1 = (GridView) findViewById(R.id.gridView1);        
    gridView1.setAdapter(new ImageAdapterWrapped(this, MOBILE_OS1,gridView1));
    GridView gridView2 = (GridView) findViewById(R.id.gridView2);        
    gridView2.setAdapter(new ImageAdapterWrapped(this, MOBILE_OS2,gridView1));

}