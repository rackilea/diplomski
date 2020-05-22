/**
 * Helper functions for {@code CompletionStage}.
 *
 * @author Gili Tzabari
 */
public final class Completions
{
    /**
     * Returns a {@code CompletionStage} that is completed with the value or exception of the {@code CompletionStage}
     * returned by {@code callable} using the supplied {@code executor}. If {@code callable} throws an exception the
     * returned {@code CompletionStage} is completed with it.
     *
     * @param <T>      the type of value returned by {@code callable}
     * @param callable returns a value
     * @param executor the executor that will run {@code callable}
     * @return the value returned by {@code callable}
     */
    public static <T> CompletionStage<T> supplyAsync(Callable<T> callable, Executor executor)
    {
        return CompletableFuture.supplyAsync(() -> wrapExceptions(callable), executor);
    }

    /**
     * Wraps or replaces exceptions thrown by an operation with {@code CompletionException}.
     * <p>
     * If the exception is designed to wrap other exceptions, such as {@code ExecutionException}, its underlying cause is wrapped; otherwise the
     * top-level exception is wrapped.
     *
     * @param <T>      the type of value returned by the callable
     * @param callable an operation that returns a value
     * @return the value returned by the callable
     * @throws CompletionException if the callable throws any exceptions
     */
    public static <T> T wrapExceptions(Callable<T> callable)
    {
        try
        {
            return callable.call();
        }
        catch (CompletionException e)
        {
            // Avoid wrapping
            throw e;
        }
        catch (ExecutionException e)
        {
            throw new CompletionException(e.getCause());
        }
        catch (Throwable e)
        {
            throw new CompletionException(e);
        }
    }

    /**
     * Returns a {@code CompletionStage} that is completed with the value or exception of the {@code CompletionStage}
     * returned by {@code callable} using the default executor. If {@code callable} throws an exception the returned
     * {@code CompletionStage} is completed with it.
     *
     * @param <T>      the type of value returned by the {@code callable}
     * @param callable returns a value
     * @return the value returned by {@code callable}
     */
    public static <T> CompletionStage<T> supplyAsync(Callable<T> callable)
    {
        return CompletableFuture.supplyAsync(() -> wrapExceptions(callable));
    }

    /**
     * Prevent construction.
     */
    private Completions()
    {}
}