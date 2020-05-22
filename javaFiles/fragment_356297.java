class OtherObj {
    MyInt a;
    synchronized void set() {
        a = new MyInt(42);
    }
    synchronized int get() {
        return (a != null) ? a.getValue() : -1;
    }
}