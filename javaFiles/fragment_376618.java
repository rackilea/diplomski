public static void joinThread(final Thread thread) {
    try {
        thread.join();
    } catch (final InterruptedException e) {
        Logger.getGlobal().log(Level.INFO, "Unexpected InterruptedException, resetting flag", e);
        Thread.currentThread().interrupt();
    }
}