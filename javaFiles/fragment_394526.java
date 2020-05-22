private static final Optional<String> getHostName() {
    try {
        return Optional.of(
            InetAddress.getLocalHost().getCanonicalHostName().toLowerCase());
    } catch (UnknownHostException ex) {
        logger.logError("error = ", ex);
        return Optional.absent();
    }
}