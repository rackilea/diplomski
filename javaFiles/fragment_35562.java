BitmapFactory.Options myOptions;
Canvas canvas;
Bitmap mutableBitmap;
Bitmap workingBitmap;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn_open= findViewById(R.id.btn_open);
    image2= findViewById(R.id.imageView);
    myOptions = new BitmapFactory.Options();
    bitmap = BitmapFactory.decodeResource(getResources(), 
    R.drawable.image000880,myOptions);
    paint= new Paint();
    paint.setAntiAlias(true);
    paint.setColor(Color.WHITE);

    workingBitmap = Bitmap.createBitmap(bitmap);
    mutableBitmap = workingBitmap.copy(Bitmap.Config.ARGB_8888, true);
    canvas = new Canvas(mutableBitmap);

   private void drawpoint(ImageView imageView,float x,float y, int raduis){
    myOptions.inDither = true;
    myOptions.inScaled = false;
    myOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;// important
    myOptions.inPurgeable = true;
//  ArrayList<Point> list= new ArrayList<>();
    canvas.drawCircle(x,y, raduis, paint);
    imageView = (ImageView)findViewById(R.id.imageView);
    imageView.setAdjustViewBounds(true);
    imageView.setImageBitmap(mutableBitmap);
}