public static void joinThread(final Thread thread) throws InterruptedException {
    try {
        thread.join();
    } catch (final InterruptedException e) {
        Logger.getGlobal().log(Level.FINE, "Got InterruptedException, propagating it to the caller", e);
        throw e;
    }
}