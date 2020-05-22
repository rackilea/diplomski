/**
 * Rethrows a {@code Throwable}, wrapping it in {@code CompletionException} if it isn't already wrapped.
 *
 * @param <T>       the return type expected by the caller
 * @param throwable a Throwable
 * @return an undefined value (the method always throws an exception)
 * @throws CompletionException wraps {@code throwable}
 */
public <T> T rethrowException(Throwable throwable)
{
    if (throwable instanceof CompletionException)
        throw (CompletionException) throwable;
    if (throwable == null)
        throwable = new NullPointerException("throwable may not be null");
    // According to https://stackoverflow.com/a/49261367/14731 some methods do not wrap exceptions
    throw new CompletionException(throwable);
}