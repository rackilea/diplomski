public class Runner {
    private ExecutorService pool = Executors.newCachedThreadPool();
    private int numUrls = 20;
    private CountDownLatch latch = new CountDownLatch(numUrls);
    private List<S3Object> results = Collections.synchronizedList(new ArrayList<S3Object>());

    public void add(String url) {
        pool.submit(new MyTask(results, latch, url));
    }

    public void go() throws Exception {

        for(int i = 0; i < numUrls; i++) {
            String url = "http://example" + i;
            add(url);
        }

        // wait for all downloads
        latch.await();

        for (S3Object result : results) {
            System.out.println("result id: " + result.id);
        }
    }
}