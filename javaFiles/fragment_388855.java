private List<Bitmap> myBitmaps;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.my_layout);
    myBitmaps = BitmapDTO.getInstance().getBitmaps();
    // Do your stuff
}