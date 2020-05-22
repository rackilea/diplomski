return stage.handle((value, throwable) ->
{
    // WARNING: By design, CompletionStage.whenComplete() suppresses any exceptions thrown by its argument, so we use handle() instead.
    deadlockListener.cancel(false);
    if (throwable == null)
        return value;
    return rethrowException(throwable);
});