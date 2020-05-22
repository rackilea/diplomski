public class CancelableReader extends BufferedReader {

    private final ExecutorService executor;
    private Future future;

    public CancelableReader(Reader in) {
        super(in);
        executor = Executors.newSingleThreadExecutor();
    }

    @Override
    public String readLine() {

        future = executor.submit(super::readLine);

        try {
            return (String) future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (CancellationException e) {
            return null;
        }

        return null;

    }

    public void cancelRead() {
        future.cancel(true);
    }

}