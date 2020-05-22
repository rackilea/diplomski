/**
 * Adapt an iterable of {@link ApiFuture} instances into a single {@code ApiFuture}.
 */
static <T> ApiFuture<Boolean> adaptFutures(Iterable<ApiFuture<T>> futures) {
    final SettableApiFuture<Boolean> result = SettableApiFuture.create();
    final ApiFuture<List<T>> allFutures = ApiFutures.allAsList(futures);
    allFutures.addListener(
        () -> {
            if (allFutures.isCancelled()) {
                result.set(Boolean.FALSE);
                return;
            }
            try {
                allFutures.get();
                result.set(Boolean.TRUE);
            } catch (ExecutionException | InterruptedException ex) {
                // Maybe log something here?
                //
                // Note that InterruptedException is actually impossible here
                // because we're running in the listener callback, but the API
                // still marks it as potentially thrown by .get() above.
                //
                // So if we reach here it means that the allAsList future failed.
                result.set(Boolean.FALSE);
            }
        },
        // Not normally safe, but we know our listener runs fast enough
        // to run inline on the thread that completes the last future.
        Runnable::run);
    return result;
}