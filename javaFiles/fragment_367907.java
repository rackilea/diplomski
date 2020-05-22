@Inject Instance<Download> downloadProvider;

public void yourMethod() {
    Download download = downloadProvider.get();
    try {
        // do something with your download instance
    } finally {
        downloadProvider.destroy(download);
    }
}