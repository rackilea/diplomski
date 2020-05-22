private Object LOCK;
public void onMessage() {
    code…
    synchronized(LOCK) {
        check if system exists, create if necessary
    }
    more code…
}