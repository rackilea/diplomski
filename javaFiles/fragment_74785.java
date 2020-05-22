public static void main(String[] args) throws InterruptedException {
    Runnable r = new Runnable() {
        public void run() {
            System.out.print(Thread.currentThread().getName());
        }
    };

    Thread t1 = new Thread(r, "One ");
    t1.start();
    Thread.sleep(2000);

    Thread t2 = new Thread(r, "Two ");
    t2.start();
    Thread.sleep(1000);

    System.out.print("Main ");
}