public static void main(String[] args) {
    final Thread mainThread = Thread.currentThread();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println(mainThread);
            System.out.println(Thread.currentThread());
            System.out.println(mainThread == Thread.currentThread());
        }
    };
    r.run();
}