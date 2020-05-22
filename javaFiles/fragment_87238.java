protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_camera);

    mPreferences = getSharedPreferences("CurrentUser", MODE_PRIVATE);

    RelativeLayout RL = (RelativeLayout) getWindow().getDecorView().findViewById(android.R.id.content);
    mTextureView = new TextureView(this);
    mTextureView.setSurfaceTextureListener(this);
    RL.addView(mTextureView);
}