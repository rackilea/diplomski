Future<Void> f = session.getAsyncRemote().sendObject(...)        
try {
    f.get(10, TimeUnit.SECONDS);
} catch (InterruptedException e) {
    throw new IOException(e);
} catch (ExecutionException e) {
    Throwable cause = e.getCause();
    if (cause instanceof IOException) {
        throw (IOException) cause;
    } else if (cause instanceof EncodeException) {
        throw (EncodeException) cause;
    } else {
        throw new IOException(e);
    }
} catch (TimeoutException e) {
    throw new IOException(e);
}