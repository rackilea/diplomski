class Super {
    public void init() { ... }
}

class Subclass extends Super {
    private Subclass() { super(); ... }
    public void init() { super.init(); ... }
    public static Subclass createInstance() {
        Subclass instance = new Subclass();
        instance.init();
        return instance;
    }
}