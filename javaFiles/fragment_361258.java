final PipedInputStream in = new PipedInputStream();
final InputStreamWithFinalExceptionCheck inWithException = new InputStreamWithFinalExceptionCheck(in);
final PipedOutputStream out = new PipedOutputStream(in);
Thread thread = new Thread(() -> {
    try {
      // Start producing the data and push it into output stream.
      // The production my fail and throw an Exception with the reason
    } catch (final IOException e) {
        inWithException.fail(e);
    } finally {
        inWithException.countDown();
    }
});
thread.start();
return inWithException;