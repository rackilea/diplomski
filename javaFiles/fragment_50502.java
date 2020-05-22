String daytonPolice = "http://relay.radioreference.com:80/691484064";
MediaPlayer mp = new MediaPlayer();

mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
});

mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
mp.setDataSource(daytonPolice); // It will not take the string of my url
mp.prepareAsync();