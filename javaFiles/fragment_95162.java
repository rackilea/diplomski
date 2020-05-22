@FunctionalInterface
interface RunnableWithEx {

    void run() throws Throwable;
}

public static void tryCatchAndLog(final RunnableWithEx tryThis) {
    try {
        tryThis.run();
    } catch (final Throwable throwable) {
        throwable.printStackTrace();
    }
}