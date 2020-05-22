/**
 * Allow async replies. If the handler reply is a {@link ListenableFuture}, send
 * the output when it is satisfied rather than sending the future as the result.
 * Ignored for return types other than {@link ListenableFuture}.
 * @param async true to allow.
 * @since 4.3
 */
public final void setAsync(boolean async) {