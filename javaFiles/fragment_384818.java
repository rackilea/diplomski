/**
 * Executes a block of code asynchronously in the application Akka Actor system.
 */
public static <T> Promise<T> future(java.util.concurrent.Callable<T> callable) {
    return asPromise(akka.dispatch.Futures.future(callable, system().dispatcher()));
}