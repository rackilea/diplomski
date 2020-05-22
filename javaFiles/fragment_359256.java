private final static MyClass myClass;

static {
    MyClass my;
    try {
        my = new MyClass();
        my.init();
    } catch (Exception e) {
        my = null;
        // log
    }
    myClass = my; //only one assignment!
}