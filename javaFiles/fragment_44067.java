public static <T> Optional<T> doWithRetry(final Supplier<T> t) {
    for (int retry = 0; retry <= StaticData.NETWORK_RETRY; ++retry) {
        try {
            Thread.sleep(retry * StaticData.NETWORK_CALL_WAIT);
            return Optional.of(t.get());
        } catch (InterruptedException | UnknownHostException e) {
            LOGGER.log(Level.SEVERE, "Call failed.", e);
            return Optional.empty();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Call failed. Retry.", e);
        }
    }
    LOGGER.log(Level.SEVERE, "Call failed. Retries exceeded.");
    return Optional.empty();
}