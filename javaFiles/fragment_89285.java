public static void main(String[] args) {
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                System.out.println("Daemon thread");
            }
        }
    });
    t.setDaemon(true);
    t.start();

    System.out.println("End of main");
}