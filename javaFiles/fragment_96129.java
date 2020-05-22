public class MediaPlayerSingleton extends MediaPlayer{
    private static MediaPlayerSingleton mediaPlayerSingleton;

    private MediaPlayerSingleton() {}

    public static MediaPlayerSingleton getInstance() {
        synchronized (mediaPlayerSingleton)  { // if you'll be using it in moe then one thread
            if(mediaPlayerSingleton == null)
                mediaPlayerSingleton = new MediaPlayerSingleton();
        }

        return mediaPlayerSingleton;
    }

}