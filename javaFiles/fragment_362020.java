public final AtomicInteger i = new AtomicInteger();
...
// no need for synchronized here
public int get() {
    return i.get();
}
// nor here
public int getAndIncrement() {
    return i.getAndIncrement();
}