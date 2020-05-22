public class Injector {
    private Injector() {
    }

    private static SingletonComponent singletonComponent;

    static {
        singletonComponent = DaggerSingletonComponent.create();
    }

    public static SingletonComponent get() {
        return singletonComponent;
    }
}