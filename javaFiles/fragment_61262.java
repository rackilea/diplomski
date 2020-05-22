public class Command implements ResponseListener {
    private String cause;

    // ...
    @Override
    public void messageReceived(String message, String status) {
        // ...
        if (!status.equals(MyConstants.COMPLD_MSG)) {
            this.cause = status + " received for " + command.split(":")[0] + message;
            this.failed = true;
        }
        doNotify();
    }

    @Override
    public void exceptionCaught(Throwable cause) {
        if(cause.getMessage().isEmpty()) {
            this.cause = cause.toString();
        }
        else {
            this.cause = cause.getMessage();
        }
        this.failed = true;
        doNotify();
    }

    public void waitForResponse(int cmdTimeout) throws IOException, InterruptedException {
        // ...
        if (failed)
            throw new IOException(cause);
    }
}