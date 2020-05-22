public static void joinThread(final Thread thread) {
    while (true)
        try {
            thread.join();
            return;
        } catch (final InterruptedException e) {
            Logger.getGlobal().log(Level.ERROR, "Unexpected InterruptedException", e);
        }
}