public static MySystem getInstance() {
    MySystem my = instance;
    if (my == null) {                            // (1) instance was null => my is null and synchronized block is entered.
        synchronized (MySystem.class) {
            if (instance == null) {              // (2) instance was updated from another thread and is not null anymore.
                instance = my = new MySystem();
            }
        }
    }
    return my;
}