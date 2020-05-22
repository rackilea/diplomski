private AtomicReference<T> atomic = new AtomicReference<T>(null);
public static void doIfUnequal(T obj) {
    T curVal;
    while((curVal = atomic.get()) != obj) {
        if(atomic.compareAndSet(curVal, obj)) {
            doSomething();
            break;
        }
    }
}