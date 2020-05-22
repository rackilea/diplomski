@Override
public void onChange(boolean selfChange) {
    super.onChange(selfChange);

    AudioManager audio = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    int currentVolume = audio.getStreamVolume(AudioManager.STREAM_MUSIC);

    processVolumeChange(currentVolume);
}

public void processVolumeChange(int currentVolume) {
    MyService mService = new MyService();
    mService.volumeCheck(previousVolume - currentVolume); //Method in my service
    previousVolume = currentVolume;
}