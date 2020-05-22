final Runnable run = new Runnable() {
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
};
Thread t1 = new Thread(run, "t1");
Thread t2 = new Thread(run, "t2");  //new Thread(t1, "t2"); is incorrect!
t1.start();
t2.start();