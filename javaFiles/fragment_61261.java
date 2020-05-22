public class Command implements ResponseListener {
    private Throwable cause;

    // ...
    @Override
    public void messageReceived(String message, String status) {
        // ...
        if (!status.equals(MyConstants.COMPLD_MSG)) {
            this.cause = new Throwable(status + " received for " + command.split(":")[0] + message);
            this.failed = true;
        }
        doNotify();
    }

    @Override
    public void exceptionCaught(Throwable cause) {
        this.cause = cause;
        this.failed = true;
        doNotify();
    }

    public void waitForResponse(int cmdTimeout) throws IOException, InterruptedException {
        // ...
        if (failed)
            throw new IOException(cause);
    }
}