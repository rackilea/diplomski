public class Mp3PlayerService extends Service implements
        MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnSeekCompleteListener {

    /** Android Built-in Media Player */
    public MediaPlayer player;

    /** Binder for Mp3 Service */
    private final IBinder iBinder = new Mp3PlayerService.BackgroundAudioServiceBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        player = new MediaPlayer();
        player.setOnCompletionListener(this);
        player = new MediaPlayer();
        try {
          playSongLocal();
          playSongNetwork();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }


    private void playsongLocal() {
        AssetFileDescriptor afd;
        player.reset();
        try {
            LogUtils.LOGE(TAG, "playing aaa.mp3");
            afd = getApplicationContext().getAssets().openFd("aaa.mp3");
            player.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playsongNetwork() {
        player.reset();
        try {
            player.setDataSource(networkUrlLink);
            player.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void onDestroy() {
        if (player.isPlaying()) {
            player.stop();
        }
        player.release();
    }

    /** return itself when beeing asked */
    public class BackgroundAudioServiceBinder extends Binder {
        public Mp3PlayerService getService() {
            return Mp3PlayerService.this;
        }
    }