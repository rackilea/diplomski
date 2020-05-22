private static final class InputStreamWithFinalExceptionCheck extends FilterInputStream {
    private final AtomicReference<IOException> exception = new AtomicReference<>(null);
    private final CountDownLatch complete = new CountDownLatch(1);

    public InputStreamWithFinalExceptionCheck(final InputStream stream) {
        super(stream);
    }

    @Override
    public void close() throws IOException {
        try {
            complete.await();
            final IOException e = exception.get();
            if (e != null) {
                throw e;
            }
        } catch (final InterruptedException e) {
            throw new IOException("Interrupted while waiting for synchronised closure");
        } finally {
            stream.close();
        }
    }

    public void fail(final IOException e) {
        exception.set(Preconditions.checkNotNull(e));
    }

    public void countDown() {complete.countDown();}
}