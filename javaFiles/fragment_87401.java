public static void main(String[] args) throws InterruptedException {
    final CountUpAndDownLatch latch = new CountUpAndDownLatch(1);
    Runnable up = new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println("IN UP " + latch.getCount());
                latch.countUp();
                System.out.println("UP " + latch.getCount());
            } catch (InterruptedException ex) {
            }
        }
    };

    Runnable downOrWait = new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println("IN DOWN " + latch.getCount());
                latch.countDownOrWaitIfZero();
                System.out.println("DOWN " + latch.getCount());
            } catch (InterruptedException ex) {
            }
        }
    };

    Runnable waitFor0 = new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println("WAIT FOR ZERO " + latch.getCount());
                latch.waitUntilZero();
                System.out.println("ZERO " + latch.getCount());
            } catch (InterruptedException ex) {
            }
        }
    };
    new Thread(waitFor0).start();
    up.run();
    downOrWait.run();
    Thread.sleep(100);
    downOrWait.run();
    new Thread(up).start();
    downOrWait.run();
}