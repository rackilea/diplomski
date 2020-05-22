public class StoppedException extends RuntimeException {

}

public class StoppableInputStream extends InputStream {

    private boolean stopped;
    private InputStream wrappedStream;

    public StoppableInputStream(InputStream wrapped) {
        wrappedStream = wrapped;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        return this.stopped = stopped;
    }

    public int read() {
        if (stopped)
            throw new StoppedException();
        return wrappedStream.read();
    }

    public int read(byte[] b) {
        if (stopped)
            throw new StoppedException();
        return wrappedStream.read(b);
    }

    public int read(byte[] b, int off, int len) {
        if (stopped)
            throw new StoppedException();
        return wrappedStream.read(b, off, len);
    }

    // do the same for all other methods of InputStream
}