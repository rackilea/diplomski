public class MusicPlayerService extends android.app.Service implements MediaPlayer.OnPreparedListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnCompletionListener,
        ObserverSubject {

    private static final int NOTIFY_ID = 1;
    private List<MusicPlayerObserver> mObservers;

    private MediaPlayer mMediaPlayer;
    private final IBinder playerBind = new MusicBinder();;

    private List<Track> mPlaylist;
    private Integer mPosition;

    private Boolean isRepeating;
    private Boolean isShuffling;
    private Boolean isPrepared;
    private Boolean isPaused;

    // Callback Methods______________________________________________
    @Override
    public void onCreate() {
        ...
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        ...
    }

    @Override
    public IBinder onBind(Intent intent) {
        return playerBind;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        mMediaPlayer.stop();
        mMediaPlayer.release();
        return false;
    }

    @Override
    public void onDestroy() {
        stopForeground(true);
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        mp.reset();
        return false;
    }


    // UTIL METHODS__________________________________________________
    private Long getCurrentTrackId() {
        return mPlaylist.get(mPosition).getTrackId();
    }

    private Long getCurrentAlbumId() {
        return mPlaylist.get(mPosition).getAlbumId();
    }



    // MEDIA PLAYER INTERFACE________________________________________

    public void play() {
        ...
    }

    public void pause() {
        ...
    }

    public void resume() {
        ...
    }

    public void next() {
        ...
    }

    public void previous() {
        ...
    }

    public void seekTo(int pos) {
        ...
    }

    // SERVICE INTERFACE PROVIDER_____________________________________
    /**
     * Interface through the component bound to this service can interact with it
     */
    public class MusicBinder extends Binder {
        public MusicPlayerService getService() {
            return MusicPlayerService.this;
        }
    }
}