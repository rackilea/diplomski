class JunitTest {
    public void testRunZipper() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                if (event == WatchedEvent.EVENT_2) { latch.countDown(); }
            }
        };
        MultithreadingInUnitTest testEx = new MultithreadingInUnitTest();
        testEx.setWatcher(watcher);

        testEx.runZipper();
        latch.await(10, TimeUnit.SECONDS);
        if (latch.getCount() != 0) { Assert.fail("Latch was never triggered"); }

        //assert statement to check whether zip file is created
    }

}