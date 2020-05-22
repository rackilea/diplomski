synchronized void methodA() {
    while (true) {
        System.out.println("inside A , " + Thread.currentThread()
                                                 .getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // handle it
        }
    }
}