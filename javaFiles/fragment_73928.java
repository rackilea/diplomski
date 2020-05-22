public class Singleton {
    private static Singleton mInstance = null;

    public static Singleton getInstance() {
        if (mInstance == null)
            mInstance = new Singleton();
        return mInstance;
    }

    // Other code here

}