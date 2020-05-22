// this provides memory synchronization with the internal volatile int
private AtomicInteger i;
...
public void run() {
   i.incrementAndGet();
}
...
a.start();
// still a race condition here so probably need the join to wait for a to finish
a.join();
System.out.println(a.i.get());