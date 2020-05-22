static int x;
static int y;

public static void main(String[] args) {
    Thread t1 = new Thread() {
        @Override public void run() {
            x = 1;
            y = 1;
        }
    };
    Thread t2 = new Thread() {
        @Override public void run() {
            y = 2;
            x = 2;
        }
    };
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(x + "" + y);
}