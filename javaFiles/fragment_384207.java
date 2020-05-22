interface LegacyProcess<C extends ProcessExecutionContext> {
    Future<?> performAsync(C context);
}
public interface Process<C extends ProcessExecutionContext> extends LegacyProcess<C> {
    @Override ListenableFuture<?> performAsync(C context);
}