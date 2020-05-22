public class A<T extends Comparable<T>> {

    // this is just an example of usage of T type
    List<T> comparables;

    ExecutorService someExecutorService = null;

    int compareSomething(T smth) {
        return this.comparables.get(0).compareTo(smth);
    }

    <V> Future<V> submit(Callable<V> task) {
        return this.someExecutorService.submit(task);
    }

    @SuppressWarnings("unchecked")
    <V, W extends Callable<V> & Comparable<T>> Future<V> betterSubmit(W task) {
        if(this.compareSomething((T) task) != 0)
            throw new RuntimeException("");
        return this.someExecutorService.submit(task);
    }
}