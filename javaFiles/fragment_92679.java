class MyTask implements Runnable {
    private final List<S3Object> list;
    private final CountDownLatch latch;
    private final String url; 

    public MyTask(List<S3Object> list, CountDownLatch latch, String url) {
        this.list = list;
        this.latch = latch;
        this.url = url;
    }     

    public void run() {
        S3Downloader downloader = new S3Downloader();
        S3Object result = downloader.download(url);
        list.add(result);
        latch.countDown();
    }
}