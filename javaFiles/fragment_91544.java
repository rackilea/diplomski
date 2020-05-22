public static MySystem getInstance() {
    MySystem my = instance;
    if (my == null) {
        synchronized (MySystem.class) {
            if (instance == null) {
                instance = new MySystem();
            }
        }
        my = instance;
    }
    return my;
}