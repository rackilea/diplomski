protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.LAYOUT_NAME);

    Button zoonIn = (Button)findViewById(R.id.ZOOM_IN_BUTTON_ID);
    Button zoonOut = (Button)findViewById(R.id.ZOOM_OUT_BUTTON_ID);

    final TouchImageView touch = (TouchImageView)findViewById(R.id.YOUR_TOUCH_IMAGE_VIEW_)ID);

    Bitmap bImage = BitmapFactory.decodeResource(this.getResources(), R.drawable.DRAWABLE_ID);

    touch.setImageBitmap(bImage);

    touch.setMaxZoom(4f); //change the max level of zoom, default is 3f


    zoonIn.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            touch.zoomIn();
        }
    });


    zoonOut.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            touch.zoomOut();
        }
    });

}