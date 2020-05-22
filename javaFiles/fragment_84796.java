class Singleton {
    private static final instance = new Singleton();

    private Singleton() {} // prevent outside construction

    public static Singleton getInstance() {
        return instance; // no synchronization needed
    }
}