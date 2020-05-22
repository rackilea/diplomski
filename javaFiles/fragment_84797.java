class Singleton {
    private static class Holder {
        static final instance = new Singleton();
    }

    private Singleton() {} // prevent outside construction

    public static Singleton getInstance() {
        return Holder.instance; // no synchronization needed
    }
}