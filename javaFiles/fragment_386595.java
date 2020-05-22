public static void main(String[] args) throws InterruptedException {
    ...
    // CountDownLatch to be decremented 10 times to release awaiting threads
    CountDownLatch latch = new CountDownLatch(10);
    for(int i=0;i<10;i++){
        new Thread(){
            public void run() {
                try {
                    ...
                } finally {
                    // Decrement it as the task is over
                    latch.countDown();
                }

            };
        }.start();
    }
    // Await until the countdown reaches 0
    latch.await();
    System.out.println(test.inc);
}