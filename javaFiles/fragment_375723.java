@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ringermode);


    InitializeShit();
    tb.setOnClickListener(this);

    mRing=(AudioManager) getSystemService(AUDIO_SERVICE);
}