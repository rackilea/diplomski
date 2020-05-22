static ArrayList a = new ArrayList(1);

public static void main(String[] args) throws Exception {
    Thread t1 = new Thread() {
        public void run() {
            while (true) {
                a.add(new Object());
            }
        }
    };

    Thread t2 = new Thread() {
        public void run() {
            while (true) {
                a = new ArrayList(1);
                a.add(new Object());
                a.add(new Object());
            }
        }
    };

    t2.start();
    Thread.sleep(100);
    t1.start();
}