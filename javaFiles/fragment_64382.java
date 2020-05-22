// Prepare a mutable object for use in your class
final AtomicInteger a = new AtomicInteger(123);
Button b = new Button(){
    public void someMethod() {
        ...
        int n = a.intValue();
        ...
    }
};