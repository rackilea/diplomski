public class Singleton {
    private final static Singleton mInstance = new Singleton();
    private final static Context sContext;

    private Singleton() {
        sContext = MyApplication.getInstance();
        // do more
    }

    public static Singleton getInstance() {
        return mInstance;
    }
}