public class Singleton  {

    private static Singleton INSTANCE = null;

    private Singleton() {
        init();
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return(INSTANCE);
    }

    private void init() {
        Log.d(TAG, "is this firing");
    }
}