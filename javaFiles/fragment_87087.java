@Bind(R.id.container)
ViewGroup container;

@Bind(R.id.image)
ImageView image;
private GestureDetectorCompat detector;
private float yscale = 1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
    ButterKnife.bind(this);
    image.setScaleType(ImageView.ScaleType.MATRIX);

    detector = new GestureDetectorCompat(this, new GestureDetector.SimpleOnGestureListener() {

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Matrix m = new Matrix();
            yscale += distanceY / container.getHeight();
            m.setScale(1, yscale, 0, 0);
            image.setImageMatrix(m);
            return true;
        }
    });
}

@Override
public boolean onTouchEvent(MotionEvent event) {
    return detector.onTouchEvent(event);
} detector.onTouchEvent(event);
}