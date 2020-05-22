public static ClassicSingleton getInstance() {
    if (instance == null) {
        instance = new ClassicSingleton();
    }
    return instance;
}