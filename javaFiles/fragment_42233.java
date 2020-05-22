@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AudioManager mgr=null;
    mgr=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
    mgr.setStreamVolume(AudioManager.STREAM_MUSIC, 0, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
    finish();
}