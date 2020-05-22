abstract class MediaPlayerWrapper {

    private final MediaPlayer mediaPlayer;

    MediaPlayerWrapper(MediaPlayer mediaPlayer) {
       this.mediaPlayer = mediaPlayer;
    }

    MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    abstract void action();
}