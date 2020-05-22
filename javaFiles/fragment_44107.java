public interface Singleton {
    void foo();
}

public final class SingletonAccessor {

    public static Singleton getInstance() {
        return SingletonImpl.INSTANCE;
    }

    private SingletonAccessor() {
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