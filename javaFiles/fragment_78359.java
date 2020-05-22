synchronized void methodA() {
    while (true) {
        notify();
        System.out.println("inside A , " + Thread.currentThread()
                                                 .getName());
        try {
            wait();
        } catch (InterruptedException e) {
            // handle it
        }
    }
}