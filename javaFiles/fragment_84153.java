public final class Singleton implements Serializable {
    // For lazy-laoding (if only you want)
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
        if (SingletonHolder.INSTANCE != null) {
            // throw Some Exception
        }
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // To avoid deserialization create new instance
    @SuppressWarnings("unused")
    private Singleton readResolve() {
        return SingletonHolder.INSTANCE;
    }
}