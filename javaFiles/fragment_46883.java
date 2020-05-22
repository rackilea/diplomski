static final Timer t = new Timer();
static final long delay = 1000;
public static void main(String[] args) {
  t.schedule(new A(), delay);
}
static class A extends TimerTask { public void run() {
    // do stuff;
    t.schedule(new B(), delay);
} }
static class B extends TimerTask { public void run() {
    // do stuff;
    t.schedule(new C(), delay);
} }
static class C extends TimerTask { public void run() {
    // do stuff;
    t.schedule(new A(), delay);
} }