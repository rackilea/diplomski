public abstract class Base {
    public Base(int i) {
        /* ... */
    }
    /* ... */
}

public class SingletonBase extends Base {
    private static final SingletonBase _instance = new SingletonBase();

    private SingletonBase() {
        super(0);
    }

    public static SingletonBase getInstance() {
        return _instance;
    }
    /* ... */
}