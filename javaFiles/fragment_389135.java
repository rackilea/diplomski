class MySingleton {
    private static MySingleton instance = null;

    // Prevent it from being instantiated
    MySingleton() {}

    public static synchronized MySingleton getInstance() {
        if (instance == null) {
            instance = this;
        }
        return instance;
    }
}