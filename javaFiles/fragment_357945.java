import java.util.concurrent.*;
import java.util.function.*;

public class MyCompletableFuture<T> extends CompletableFuture<T> {
    public static <T> CompletableFuture<T> supplyAsync(Supplier<T> s, Executor e) {
        return my(CompletableFuture.supplyAsync(s, e), e);
    }
    private static <T> CompletableFuture<T> my(CompletableFuture<T> f, Executor e) {
        MyCompletableFuture<T> my=new MyCompletableFuture<>(f, e);
        f.whenComplete((v,t)-> {
            if(t!=null) my.completeExceptionally(t); else my.complete(v);
        });
        return my;
    }
    private final CompletableFuture<T> baseFuture;
    private final Executor executor;

    MyCompletableFuture(CompletableFuture<T> base, Executor e) {
        baseFuture=base;
        executor=e;
    }
    private <T> CompletableFuture<T> my(CompletableFuture<T> base) {
        return my(base, executor);
    }
    @Override
    public CompletableFuture<Void> acceptEitherAsync(
            CompletionStage<? extends T> other, Consumer<? super T> action) {
        return my(baseFuture.acceptEitherAsync(other, action, executor));
    }
    @Override
    public <U> CompletableFuture<U> applyToEitherAsync(
            CompletionStage<? extends T> other, Function<? super T, U> fn) {
        return my(baseFuture.applyToEitherAsync(other, fn, executor));
    }
    @Override
    public <U> CompletableFuture<U> handleAsync(
            BiFunction<? super T, Throwable, ? extends U> fn) {
        return my(baseFuture.handleAsync(fn, executor));
    }
    @Override
    public CompletableFuture<Void> runAfterBothAsync(
            CompletionStage<?> other, Runnable action) {
        return my(baseFuture.runAfterBothAsync(other, action, executor));
    }
    @Override
    public CompletableFuture<Void> runAfterEitherAsync(
            CompletionStage<?> other, Runnable action) {
        return my(baseFuture.runAfterEitherAsync(other, action, executor));
    }
    @Override
    public CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> action) {
        return my(baseFuture.thenAcceptAsync(action, executor));
    }
    @Override
    public <U> CompletableFuture<Void> thenAcceptBothAsync(
            CompletionStage<? extends U> other,
            BiConsumer<? super T, ? super U> action) {
        return my(baseFuture.thenAcceptBothAsync(other, action, executor));
    }
    @Override
    public <U> CompletableFuture<U> thenApplyAsync(
            Function<? super T, ? extends U> fn) {
        return my(baseFuture.thenApplyAsync(fn, executor));
    }
    @Override
    public <U, V> CompletableFuture<V> thenCombineAsync(
            CompletionStage<? extends U> other,
            BiFunction<? super T, ? super U, ? extends V> fn) {
        return my(baseFuture.thenCombineAsync(other, fn, executor));
    }
    @Override
    public <U> CompletableFuture<U> thenComposeAsync(
            Function<? super T, ? extends CompletionStage<U>> fn) {
        return my(baseFuture.thenComposeAsync(fn, executor));
    }
    @Override
    public CompletableFuture<Void> thenRunAsync(Runnable action) {
        return my(baseFuture.thenRunAsync(action, executor));
    }
    @Override
    public CompletableFuture<T> whenCompleteAsync(
            BiConsumer<? super T, ? super Throwable> action) {
        return my(baseFuture.whenCompleteAsync(action, executor));
    }
}