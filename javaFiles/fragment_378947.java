MediaPlayer mediaPlayer = new MediaPlayer();

mp.setDataSource(context, Uri.parse("http://www.domian.com/ola.mp3"));
mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
mp.prepare();

mp.setOnPreparedListener(new OnPreparedListener() {
        @Override
        public void onPrepared(MediaPlayer mp) {

            mp.start();
        }
    });
    mediaPlayer.setOnErrorListener(new OnErrorListener() {
        @Override
        public boolean onError(MediaPlayer mp, int what, int extra) {
             // Display error
            return false;
        }
    });