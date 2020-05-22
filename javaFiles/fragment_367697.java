ExecutorService pool = Executors.newFixedThreadPool(10);
for (String name : fileNames) {
    pool.submit(new DownloadTask(name, toPath));
}
pool.shutdown();
pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
// all tasks have now finished (unless an exception is thrown above)