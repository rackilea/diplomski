void method() {
    int x = 10;
    Runnable r = new Runnable() {
        @Override public void run() {
            System.out.println(x);
        }
    };
    x = 20;
    r.run(); // Should this print 10 or 20?
}