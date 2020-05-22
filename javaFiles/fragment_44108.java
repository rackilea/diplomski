public enum SingletonAccessor {

    SINGLETON;

    public Singleton get() {
        return SingletonImpl.INSTANCE;
    }

    private enum SingletonImpl implements Singleton {
        INSTANCE;
        public void foo() {
            // ...
        }
        public void bar() {
            // ...
        }
    }

}