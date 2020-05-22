public static synchronized SingletonClass getInstance() {
    if (instance == null) {
            singleton = new SingletonClass();
    }
    return singleton;
}