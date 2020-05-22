private static class DownloadTask implements Runnable {

    private String name;
    private final String toPath;

    public DownloadTask(String name, String toPath) {
        this.name = name;
        this.toPath = toPath;
    }

    @Override
    public void run() {
        // surround with try-catch if downloadFile() throws something
        downloadFile(name, toPath);
    }
}