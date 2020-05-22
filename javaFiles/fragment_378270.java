.......
  customClassPackageName.CustomSurfaceViewClassName surfaceView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    surfaceView = (customClassPackageName.CustomSurfaceViewClassName) findViewById(R.id.surfaceView);
    .......