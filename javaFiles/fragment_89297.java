class Service {

    private Downloader downloader;
    private ExecutorService service;

    public Service (Downloader downloader, ExecutorService service) {
        //set variables
    }

    public void doWork(List<String> list) {
        for (String item : list) {
            service.submit(() -> {
                downloader.download(item);
            });
        }
    }
}