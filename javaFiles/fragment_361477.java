new Thread() {
    @Override
    public void run() {
        while (true) {
            // Says "blah" every half second
            System.out.println("blah");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                // nope
            }
        }
    }
}.start();