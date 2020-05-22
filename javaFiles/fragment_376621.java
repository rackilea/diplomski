// Only throws AssertionError if assertions are enabled.
public static void joinThread(final Thread thread) {
    try {
        thread.join();
    } catch (final InterruptedException e) {
        Logger.getGlobal().log(Level.ERROR, "Unexpected InterruptedException", e);
        assert false : e;
    }
}

// Always throws AssertionError.
public static void joinThread(final Thread thread) {
    try {
        thread.join();
    } catch (final InterruptedException e) {
        Logger.getGlobal().log(Level.FATAL, "Unexpected InterruptedException", e);
        throw new AssertionError(e, "Unexpected Thread interruption.");
    }
}