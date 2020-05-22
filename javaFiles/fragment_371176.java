public class GameSounds {
    private static Context sContext;

    public static void setContext(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null!");
        }

        // In order to avoid memory leak, you should use application context rather than the `activiy`
        context = context.getApplicationContext();
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null!");
        }

        sContext = context;
    }

    private static Context getContext() {
        if (sContext != null) {
            return (Context)sContext;
        }
        throw new IllegalStateException("sContext was not set yet! Please call method setContext(Context context) first.");
    }

    // the rest of other methods. e.g. playSounds()
    private static GameSounds gameSounds = new GameSounds();
    private GameSounds() {

    }

    public static GameSounds getInstance() {
        return gameSounds;
    }


    public void playSound() {

        Context context = getContext();

        soundPlayer = MediaPlayer.create(context, mySoundId);
        soundPlayer.start();
    }
}