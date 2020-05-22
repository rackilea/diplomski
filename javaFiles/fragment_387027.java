SoundPool soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

static int StreamID;
static int Sound;

Sound = soundPool.load(this, R.raw.sndRes, 1);
...

btnStart.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View view) {
        StreamID = soundPool.play(Sound, 1, 1, 0, 0, 1);
    }
});