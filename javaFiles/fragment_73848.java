public static void main(String[] args) {
    Thread t = new Thread() {
        public void run() {
            try {
                Thread.sleep(5 * 60 * 1000L);
            }
            catch (InterruptedException e) {
            }
            System.exit(0);
        }
    };
    t.start();

    utils.MulticastTest.main(args);
}