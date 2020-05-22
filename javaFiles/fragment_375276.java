...
    Thread t1 = new Thread();
    synchronized(t1) {
        t1.start();
        System.out.print("1 ");
        t1.wait(5000);
    }
...