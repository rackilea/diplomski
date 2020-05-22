public static void joinThread(final Thread thread) {
    try {
        thread.join();
    } catch (final InterruptedException e) {
        Logger.getGlobal().log(Level.FINE, "Got InterruptedException, handling it", e);
        // ...whatever...
    }
}