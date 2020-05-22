import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicReference

class OneAtATime<out T> {
    private val pending = AtomicReference(CompletableFuture<T>())
    init {
        startFetching(pending.get())
    }

    fun get(): T {
        val current = pending.get()
        if (!current.isDone) {
            return current.get()
        }
        val next = CompletableFuture<T>()
        return if (pending.compareAndSet(current, next)) {
            startFetching(next)
            next.get()
        } else {
            pending.get().get()
        }
    }

    private fun startFetching(future: CompletableFuture<T>) {
        TODO("Implementation must call future.complete(newContent)")
    }
}