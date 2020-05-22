private static volatile SingletonClass singleton;
// ...
public static SingletonClass getInstance() { // Only works reliably on Java 5 (aka 1.5) and later!
    SingletonClass instance = singleton;
    if (instance == null) {
        synchronized (SingletonClass.class) {
            instance = singleton;
            if (instance == null) {
                singleton = instance = new SingletonClass();
            }
        }
    }
    return instance;
}