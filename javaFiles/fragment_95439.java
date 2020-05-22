public class App extends MultiTouchActivity {

    SoundPool sp;
    int  mSoundId;
    int  mStreamId = 0;

@Override
public void onCreate(Bundle savedInstanceState) {
    sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
    mSoundId = sp.load(this, R.raw.dub1, 1);
}

public void dubstep1(View view) {
    if(mStreamId != 0) {
        sp.stop(mStreamId);
    }
    mStreamId = sp.play(mSoundId, 1, 1, 1, 0, 1f);
}