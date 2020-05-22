public class SampleThreads {
    private static final CountDownLatch latch = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Starting ThreadTesting!!!!");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        try {
            Future<List<Double>> webResponse = executor.submit(new WebCallThread());
            Future<List<Double>> restResponse = executor.submit(new RestCallThread());
            latch.await();
            System.out.println("Success WebCall!!!!");
            System.out.println(webResponse.get());
            System.out.println(restResponse.get());
            System.out.println("Finished ThreadTesting!!!!");
        } finally {
            executor.shutdown();
        }
    }

    static class WebCallThread implements Callable<List<Double>> {
        @Override
        public List<Double> call() throws Exception {
            final List<Double> dblList = new ArrayList<>();
            System.out.println("Starting WebCallThread!!!!");
            int ctr = 0;
            while (true) {
                if (ctr > 5) {
                    latch.countDown();
                    System.out.println("Finished WebCallThread!!!!");
                    return dblList;
                }
                System.out.println("Adding to WebCallThread :: " + ctr);
                dblList.add(Math.random());
                ctr++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class RestCallThread implements Callable<List<Double>> {
        @Override
        public List<Double> call() throws Exception {
            List<Double> statelList = new ArrayList<>();
            System.out.println("Starting RestCallThread!!!!");
            int ctr = 0;
            while (true) {
                if (ctr > 10) {
                    latch.countDown();
                    System.out.println("Finished RestCallThread!!!!");
                    return statelList;
                }
                System.out.println("Adding to RestCallThread :: " + ctr);
                statelList.add(Math.random());
                ctr++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}