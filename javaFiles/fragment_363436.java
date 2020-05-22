ImageView myPic;
 TextView myName ;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    Bundle bnd = getIntent().getExtras();
    userId = bnd.getInt("userid");
    name = bnd.getString("name");
    thePicture = bnd.getString("mypic");
    byte[] encodeByte = Base64.decode(thePicture,
            Base64.DEFAULT);
    profpic = BitmapFactory.decodeByteArray(encodeByte, 0,
            encodeByte.length);

    setContentView(R.layout.owners_info_layout);
    ImageView myPic = (ImageView) findViewById(R.id.imageView1);
    TextView myName = (TextView) findViewById(R.id.textView1);
    myPic.setImageBitmap(profpic);
    myName.setText(name);