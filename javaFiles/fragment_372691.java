final Object foo = new Object();
synchronized (foo)
{
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            synchronized (foo) {
                System.out.println("In the new thread!");
            }
        });
    t1.start();
    t1.join();
});