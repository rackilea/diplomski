@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDetector = new GestureDetectorCompat(this, this);
        circle = new CircleView(this);
        setContentView(circle);
    }