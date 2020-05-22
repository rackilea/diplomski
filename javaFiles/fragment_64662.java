@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.imageView);
    imageView.setImage(ImageSource.resource(R.drawable.cincinnatinight));
}