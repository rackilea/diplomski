public class CachedImage {

    private static final ReferenceQueue<CachedImage> 
            refQue = new ReferenceQueue<CachedImage>();

    static {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        FileReference ref = (FileReference)refQue.remove();
                        File f = ref.getFile();
                        f.delete();
                    }
                } catch (Throwable t) {
                    _log.error(t);
                }
            }
        };
        t.setDaemon(true);
        t.start();
    }

    private final FileReference _ref;

    public CachedImage(BufferedImage bi, File tempFile) {
        tempFile.deleteOnExit();
        saveAndFree(bi, tempFile);
        _ref = new FileReference<CachedImage>(this, refQue, tempFile);
    }
    ...
}