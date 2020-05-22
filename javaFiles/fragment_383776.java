@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);

    setContentView(R.layout.image);
 text=(TextView)findViewById(R.id.text);
    this.detector=new GestureDetectorCompat(this,this);
}