public void push(Object x) {
  synchronized(this) {
    synchronized (list) { // cannot get a lock on `list` while pop() is called.
        list.addLast(x);
        this.notify();
    }
  }
}

public Object pop() throws Exception {
  synchronized(this) {
    synchronized (list) {
        if (list.size() <= 0) {
            this.wait(); // releases the lock on `this`, but keep the lock on `list`
        }
        return list.removeLast();
    }
  }
}