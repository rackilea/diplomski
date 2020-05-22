// Declare globally if needed
    int mySoundId;
    SoundPool soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0 );
    AssetManager am = this.getAssets();

    //Use in whatever method is used to load the sounds
    try {
        mySoundId = soundPool.load(am.openFd("instruments/data/bongo/audio/bong1.wav"), 1);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }