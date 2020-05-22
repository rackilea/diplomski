Thread t = new Thread() {
        public void run() { 
            synchronized (Thread.currentThread()) {
                System.out.println("Thread");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
            }
        }
    };
    t.start();
    Thread.sleep(10);//sleep main thread
    synchronized (t) {
        System.out.println("Main Thread");
    }
}