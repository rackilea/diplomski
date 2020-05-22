final int count = 10;
CountDownLatch latch = new CountDownLatch(count);
List<Thread> list = new ArrayList<Thread>();
for (int i = 0; i < count; i++) {
    list.add(new Thread() {

        public void run() {
            for (int i = 0; i < 100000; i++) {
                Counter.getInstance().n.incrementAndGet();
            }
            latch.countDown();
        }
    });
}
for (Thread thread : list) {
    thread.start();
}

latch.await();

System.out.println(Counter.getInstance().n);