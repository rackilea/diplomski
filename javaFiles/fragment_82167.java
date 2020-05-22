public class AudioPlayer implements MediaPlayer.OnCompletionListener { // 1

    public MediaPlayer mPlayer = new MediaPlayer();

    public AudioPlayer(String source, boolean loop) {
        configurePlayer(source, loop);
        mPlayer.setOnCompletionListener(this); // 3
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) { // 2
        token = true;
    }

    /* the other class implementation */
}