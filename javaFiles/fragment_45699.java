class Walker implements Runnable {

    public void run() {
        for (int i = 0;; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                //do not respond to interruption too quickly on purpose
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                Thread.currentThread().interrupt();
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
            if (Thread.interrupted()) {
                break;
            }
        }
    }
}