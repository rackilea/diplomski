public class FileWriterWorker extends SwingWorker<File, Void> {
    private final String location;
    private final Response target;
    private final Object creator;

    public FileWriterWorker(Object creator, String location, Response target) {
        this.creator = creator;
        this.location = location;
        this.target = target;
    }

    @Override
    protected File doInBackground() throws Exception {
        File file = new File("out.txt");
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            creator.write(location, writer);
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }
        return file;
    }

    @Override
    protected void done() {
        try {
            File file = get();
            target.success(file);
        }
        catch (InterruptedException ex) {
            target.failure(new BackgroundException(ex));
        }
        catch (ExecutionException ex) {
            target.failure(new BackgroundException(ex));
        }
    }

    public interface Response {
        void success(File f);
        void failure(BackgroundException ex);
    }

    public class BackgroundException extends Exception {
        public BackgroundException(Throwable cause) {
            super(cause);
        }
    }
}