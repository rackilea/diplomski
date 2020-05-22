public static void main(String[] args) throws Exception {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    Files.walk(Paths.get("/home/random"))
                            .filter(Files::isRegularFile)
                            .map(UploadThread::new)
                            .forEach(executorService::execute);

    executorService.shutdown();
    System.out.println("upload finished....");
}