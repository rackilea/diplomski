public static void main(String[] args) {
    Main m = new Main();
    Thread t1 = new Thread(m.new SomeThread("t1"));
    Thread t2 = new Thread(m.new SomeThread("t2"));
    Thread t3 = new Thread(m.new SomeThread("t3"));
    t1.start();
    t2.start();
    t3.start();
}