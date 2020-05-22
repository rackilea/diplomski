int mCurrentIndex; // always prefix class properties with an "m"

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_song);

    Button  btnPlayPause = (Button) findViewById(R.id.btnPlayPause),
            btnNext = (Button) findViewById(R.id.btnNext),
            btnPrevious = (Button) findViewById(R.id.btnPrevious);

    Intent currSong = getIntent();
    Bundle b = currSong.getExtras();

    // load initial index only once
    mCurrentIndex = (int) b.get("songIndex");

    btnPrevious.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mCurrentIndex = mCurrentIndex > 0 ? mCurrentIndex - 1 : mSongList.size() - 1;
            playSongNumber(mCurrentIndex);
        }
    }

    btnNext.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mCurrentIndex++;
            mCurrentIndex %= mSongList.size();
            playSongNumber(mCurrentIndex);
        }
    }

}

private void playSongNumber(int index) {

    try {
        mMediaPlayer.stop();
        mMediaPlayer.reset();
        mMediaPlayer.setDataSource(mSongList.get(index).getData());
        mMediaPlayer.prepareAsync();
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

    } catch (Exception e) {
        e.printStackTrace();
    }
}