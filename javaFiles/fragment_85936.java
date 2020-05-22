public synchronized void methodA() {
  doStuff();
}
...
public void methodB() {
    synchronized(this) {
        doStuff();
    }
}