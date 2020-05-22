@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main_page);

    doBindService();

    Intent music = new Intent();
    music.setClass(this, MusicService.class);
    startService(music);
}