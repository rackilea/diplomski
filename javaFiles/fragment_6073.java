public class SingletonExample {
    private static SingletonExample instance = null;

    // Declared private to prevent new SingletonExample 
    // outside of this class
    private SingletonExample {} 

    public static SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }

        return instance;
    }
}