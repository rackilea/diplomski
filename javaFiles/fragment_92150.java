final class Worker extends SwingWorker<Void, Void> {

    private final CountDownLatch actuallyFinishedLatch = new CountDownLatch(1);

    @Override
    protected Void doInBackground() throws Exception {
        try {
            System.out.println("Long Task Started");

            /* Simulate long running method */
            for (int i = 0; i < 1000000000; i++) {
                double d = Math.sqrt(i);
            }

            return null;
        } finally {
            actuallyFinishedLatch.countDown();
        }
    }

    public void awaitActualCompletion() throws InterruptedException {
        actuallyFinishedLatch.await();
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.execute();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }

        System.out.println("Cancelling");
        worker.cancel(true);

        try {
            worker.get();
        } catch (CancellationException e) {
            System.out.println("CancellationException properly thrown");
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {

        }

        System.out.println("Awaiting Actual Completion");
        try {
            worker.awaitActualCompletion();
            System.out.println("Done");
        } catch (InterruptedException e) {

        }
    }

}