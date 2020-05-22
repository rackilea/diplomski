public static void joinThread(final Thread thread) {
    try {
        thread.join();
    } catch (final InterruptedException e) {
        Logger.getGlobal().log(Level.ERROR, "Unexpected InterruptedException", e);
        throw new SomeException(e, "Unexpected Thread interruption.");
    }
}