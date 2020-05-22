final int numberOfParallelUploads = 5;
ExecutorService pool = Executors.newFixedThreadPool(numberOfParallelUploads);
final BoxFolder boxFolder = BoxFolder.getRootFolder(boxApi);
for (/* each input file */) {
    final String fileName = /* get next file to upload */;
    pool.execute(() -> {
        try (InputStream is = new FileInputStream(fileName)) {
            boxFolder.uploadFile(is, fileName);
        }
    });
}
pool.shutdown();
pool.awaitTermination(2, TimeUnit.HOURS); // absolute timeout for uploading all the files